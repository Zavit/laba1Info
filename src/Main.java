
public class Main
{
public static void main(String [] args)
{
    Object g = new Object();
    Object y = new Object();
    System.out.println(g);
    System.out.println(y);
    if(y == g)
    {
        System.out.println("equals");
    }
    else
    {
        System.out.println("Not equals");
        
    }
}
}
