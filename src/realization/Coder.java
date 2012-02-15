package realization;
import java.util.Arrays;

public class Coder
{
    public static void main(String[] args)
    {
        short[] masP = new short[] { 2, 5, 3, 4, 1, 6 };
        String str = "основы защиты инфы";
        String code = code(str, masP,masP.length);
        if (code != null)
        {
            System.out.println(code);
        }
        else
        {
            System.out.println("Данный метод лучше не применять");
        }
        char [] decode = decode(code,masP,masP.length);
        System.out.println(Arrays.toString(decode));
    }

    /**
     * 
     * @param str - str which code to
     * @param key - data from which code
     * @return
     */
    public static String code(String str,
                              short[] key,
                              int length)
    {
        if ((str.length() % key.length) != 0)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (short i = 0; i < str.length(); i += length)
        {
            for (short j = i; j < length + i; j++)
            {
                sb.append(str.charAt((key[j % length] - 1) + i)); // 6 операций
            }
        }

        return sb.toString();
    }
    public static char [] decode(String str,
                              short[] key,
                              int length)
    {
        if ((str.length() % key.length) != 0)
        {
            return null;
        }
       char [] decode = new char[str.length()];

        for (short i = 0; i < str.length(); i += length)
        {
            for (short j = i; j < length + i; j++)
            {
                decode[(key[j%length]-1)+i] = str.charAt(j);
            }
        }

        return decode;
    }

}
