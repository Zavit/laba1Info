package realization;

import Interface.Crypto;

public class Substitution implements Crypto
{
    private String       str;
    private final char[] begin  = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '.', ',', '!', ':', ';', '?', '-' };
    private final char[] result = { 'V', 'W', 'X', 'Y', 'Z', ' ', '.', ',', '!', ':', ';', '?', '-', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

    public Substitution(String str)
    {
        this.str = str;

    }

    @Override
    public String code()
    {
        if (str == null)
        {
            return null;
        }
        StringBuilder build = new StringBuilder();

        for (int i = 0; i < str.length(); i++)
        {
            for (int j = 0; j < begin.length || j < result.length; j++)
            {
                if (str.charAt(i) == begin[j])
                {
                    build.append(result[j]);
                }
            }
        }
        return build.toString();
    }

    @Override
    public char[] decode(String str)
    {
        if (str == null)
        {
            return null;
        }
       char [] decode = new char[str.length()];

        for (int i = 0; i < str.length(); i++)
        {
            for (int j = 0; j < begin.length || j < result.length; j++)
            {
                if (str.charAt(i) == result[j])
                {
                    decode[i] = begin[j];
                }
            }
        }
        return decode;
    }
  

}
