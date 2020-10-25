package beginner;

import org.testng.annotations.DataProvider;

public class StringOperations {

    public String concatenate(String x, String y)
    {
        String result = x + " " + y;
        return result;
    }

    public int compareString(String x, String y)
    {
        return x.compareTo(y);
    }

    public String convertLowerCase (String x)
    {
        return x.toLowerCase();
    }

    public String convertUpperCase(String x)
    {
        return x.toUpperCase();
    }


}
