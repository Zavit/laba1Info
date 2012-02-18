package realization;
import java.util.Arrays;

import Interface.Crypto;

public class Coder
{
    public static void main(String[] args)
    {
        
        ///method perestanovki
       int[] key = new int[] { 2, 5, 3, 4, 1, 6 };
        String str = "основы защиты инфы";
        
        Crypto shifr = new Transposition(str, key);
        String code = shifr.code();
        if (code != null)
        {
            System.out.println(code);
        }
        else
        {
            System.out.println("Данный метод лучше не применять");
        }
        char [] decode = shifr.decode(code);
        if (decode != null)
        {
            System.out.println(Arrays.toString(decode));
        }
        else
        {
            System.out.println("Данный метод лучше не применять");
        }
        
        
        /////////Method podstanovki
        String str1 = "I LOVE YOU";
        Crypto shifr1 = new Substitution(str1);
        String code1 = shifr1.code();
        if (code1 != null)
        {
            System.out.println(code1);
        }
        else
        {
            System.out.println("Данный метод лучше не применять");
        }
        char [] decode1 = shifr1.decode(code1);
        if (decode1 != null)
        {
            System.out.println(Arrays.toString(decode1));
        }
        else
        {
            System.out.println("Данный метод лучше не применять");
        }
       
    }
}
