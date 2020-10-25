package programs;

import java.util.List;

public class String_Regex {

    public static void main(String[] args)
    {
        String str = "go;ogle.co,m, yo'utube.com, am/azon.c;om, fli'pkart.com, netfl?ix.com";
        String newstring = str.replaceAll("[^\\w.,]","");
        String newstring2 = newstring.replaceAll("c.{2,}?m?,","com, ");
        System.out.println(newstring);
        System.out.println(newstring2);
    }
}
