import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Desert extends Component
{

    public Desert()
    {
        this.name="SomeName";
    }
    public void SetParametr()
    {
        switch(name)
        {
            case "apple":
                System.out.println("Set size");
                Scanner s= new Scanner(System.in);
                String st=s.nextLine();
                this.size=st;
                System.out.println("Set color");
                Scanner t= new Scanner(System.in);
                String tt=t.nextLine();
                this.color=tt;
                NumberOfParametrs=2;
                break;
            case "pineapple":
                System.out.println("Set size");
                Scanner s1= new Scanner(System.in);
                String st1=s1.nextLine();
                this.size=st1;
                NumberOfParametrs=1;
                break;
        }
    }
    public Desert(String food) {
       this.name=food;
    }
    @Override
    public void setName(String name) throws NameException{
        this.name = name;
        if(name.equals("apple")==false&&name.equals("pineapple")==false&&name.equals("cookie")==false&&name.equals("lemon")==false)
        {
            throw new NameException("Incorrect name");
        }
    }
    @Override
    public int CalculateCalories()
    {
        calories=0;
        switch(name)
        {
            case "apple":
                calories = 5;
                switch (size)
                {
                    case "small": calories=calories+0;break;
                    case "normal": calories=calories+2; break;
                    case "big": calories=calories+3; break;
                }
                switch (color)
                {
                    case "red": calories=calories+0; break;
                    case "green": calories=calories+1;break;
                    case "yellow": calories=calories+2;break;
                }
                break;
            case "pineapple": calories=10;
            switch(size)
            {
                case "small": calories=calories+0;break;
                case "normal": calories=calories+2;break;
                case "big": calories=calories+5;break;
            }
            break;
            case "lemon": calories=15;break;
            case "cookie": calories=20;break;
            default:
                calories=8;
        }
        return calories;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Desert des = (Desert) obj;
        return calories == des.calories
                && (name == des.name
                || (name != null &&name.equals(des.getName())))        && (size == des.size
                || (size != null && size .equals(des.size)
        )&& (color == des.color
                || (color != null && color .equals(des.color)
        )));
    }
    public void checkMethod(String way) throws MethodException
    {
        if (!way.equals("calculate") && !way.equals("sort") && !way.equals("stop")&&!way.equals("count")) {
            throw new MethodException("Incorrect Method");
        }
    }
}
