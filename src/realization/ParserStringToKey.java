package realization;

public class ParserStringToKey
{
    private String str;
    private int length;
    public ParserStringToKey(String str, int length)
    {
this.str = str;
this.length = length;
    }
    public String parse()
    {
       StringBuilder build = new StringBuilder();
       for(int i=0;i<str.length();i+=length)
       {
       build.append(str.substring(i,length+i)+"|");
       }
       return build.toString()+" -- key length is "+length+" symbols";
    }
}
