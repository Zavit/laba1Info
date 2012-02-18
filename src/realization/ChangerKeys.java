package realization;

public class ChangerKeys
{
    private int[] key;

    public ChangerKeys(int[] key)
    {
        this.key = key;
    }

    public int[] changeKey(String[] keyData)
    {
        try
        {
            key = new int[keyData.length];
            for (int i = 0; i < key.length; i++)
            {
                if (containsValueInKey(key, Integer.parseInt(keyData[i])))
                {
                    key[i] = Integer.parseInt(keyData[i]);
                }
                else
                {
                    return new int[]{-1};          
                }
                
            }
        }
        catch (Exception e)
        {
            return null;
        }
        return key;
    }

    private boolean containsValueInKey(int[] key,
                                       int newKey)
    {
        for (Integer testKey : key)
        {
            if (testKey == newKey)
            {
                return false;
            }
        }
        return true;
    }
}
