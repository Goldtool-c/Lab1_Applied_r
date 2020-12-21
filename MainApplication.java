import com.sun.source.tree.WhileLoopTree;
import org.w3c.dom.ls.LSInput;

import java.util.Scanner;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class MainApplication
{
    public static int SumCalories(Desert[] comp)
    {
        int iter=0;
        int sum=0;
        while(iter<2)
        {
            comp[iter].CalculateCalories();
            sum=sum+comp[iter].calories;
            iter++;
        }
        return sum;
    }
    public static void NaExc(String name) throws NameException
    {
        if(name.equals("apple")==false&&name.equals("pineapple")==false&&name.equals("cookie")==false&&name.equals("lemon")==false)
        {
            throw new NameException("Incorrect name");
        }
    }
    public static void Count(Component comp[])
    {
        System.out.println("Enter Name");
        Scanner s=new Scanner(System.in);
        String name=s.nextLine();
        try
        {
            NaExc(name);
        }
        catch (NameException e)
        {
            e.printStackTrace();
        }
        int iter=0;
        int counter=0;
        while(iter<2)
        {
            if(name.equals(comp[iter].getName()))
            {
                counter++;
            }
            iter++;
        }
        System.out.println("There are "+ counter+" "+name+" in your desert");
    }
    public static void PrintDesert(Component comp[])
    {
        int iter=0;
        while(iter<2)
        {
            System.out.println(comp[iter].getName()+" Size: "+comp[iter].size+" Color: "+comp[iter].color+" Calories: "+comp[iter].CalculateCalories());
            iter++;
        }
    }
    public static void main(String[] args) {
        Desert[] desert = new Desert[2];
        int iteration = 0;
        System.out.println("Enter 2 components");
        while (iteration < 2) {
            Scanner s = new Scanner(System.in);
            String product = s.nextLine();
            desert[iteration] = new Desert();
            try {
                desert[iteration].setName(product);
            } catch (NameException e) {
                e.printStackTrace();
                continue;
            }
            desert[iteration].SetParametr();
            iteration++;
        }
        iteration = 0;


        String way;
        System.out.println("Choose action: Calculate callories(calculate)/Sort(sort)/Count Components (count)/Shut down program(stop)");
        Scanner w = new Scanner(System.in);
        way = w.nextLine();
        while (!way.equals("stop")) {
            try {
                desert[0].checkMethod(way);
            }
            catch(MethodException e)
            {
                e.printStackTrace();
            }
            if (way.equals("calculate")) {
                System.out.println("There are " + SumCalories(desert) + " calories in your desert");
                PrintDesert(desert);
            }
            if (way.equals("sort")) {        //Sort
                boolean ParameterSort = true;
                if (ParameterSort) {
                    System.out.println("SORT BREAKFAST:");
                    Arrays.sort(desert, new Comparator() {                      // использование  анонимного  класса
                        public int compare(Object f1, Object f2) {
                            if (f1 == null) return 1;
                            if (f2 == null) return -1;
                            return ((Desert) f2).NumberOfParametrs > (((Desert) f1).NumberOfParametrs) ? 1 : -1;
                        }
                    });
                }
                System.out.println("________________________________________________________");
                PrintDesert(desert);
            }
            if(way.equals("count"))
            {
                Count(desert);
            }
            System.out.println("Choose action: Calculate callories(calculate)/Sort(sort)/Count(count)Shut down program(Stop)");
            Scanner r = new Scanner(System.in);
            way = r.nextLine();


        }
    }
}
