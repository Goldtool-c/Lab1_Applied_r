public abstract class Component implements Nutritous
{
    public int calories=0;
    protected String name;
    public String size="Not_found";
    public String color="Not_Found";
    public int NumberOfParametrs=0;
    public Component()
    {
        name="SomeName";
    }
    public Component(String name)  {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void setName(String name) throws NameException;
}
