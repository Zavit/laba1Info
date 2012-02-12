import java.util.Arrays;


public class Main
{
public static void main(String [] args)
{
    int []a = {5,5};
   int b = 1;
   a[b] = b = 0;
 System.out.prinln(Arrays.toString(a));  
}
}
