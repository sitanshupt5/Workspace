package beginner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOps1 {

    @Test(dataProvider = "string_data")
    public void dual_concatenation(String a, String b)
    {
        StringOperations stringOperations = new StringOperations();
        System.out.println("Concatenated string is " + stringOperations.concatenate(a,b));
    }

    @Test
    public void convert_to_upper_case()
    {
        StringOperations stringOperations = new StringOperations();
        String a  = "a b c d e f g h i j";
        System.out.println("Uppercase string is "+stringOperations.convertUpperCase(a));
    }

    @Test
    public void convert_to_lower_case()
    {
        StringOperations stringOperations =  new StringOperations();
        String a = "A B C D E F G H I J";
        System.out.println("Lowecase string is "+stringOperations.convertLowerCase(a));
    }

    @DataProvider(name = "string_data")
    public Object[][] getData()
    {
        Object[][] data = new Object[2][2];
        data[0][0] = "Subhransu";
        data[0][1] = "Nayak";
        data[1][0] = "Chandan";
        data[1][1] = "Sahu";
        return data;
    }

}
