package realization;

import Interface.Crypto;

public class Transposition implements Crypto
{
    private String str;
    private int [] key;
    private int length;
    public Transposition(String str,int [] key)
    {
        this.str = str;
        this.key = key;
        this.length = key.length;
    }
    public String code()
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
    public  char [] decode()
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
