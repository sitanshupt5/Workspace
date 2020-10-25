package beginner;

import org.testng.annotations.Test;

public class Operations1 {

    @Test(enabled = false)
    public void dualaddtion()
    {
        int a= 10;
        int b = 15;
        ArithematicOperations operations = new ArithematicOperations();
        System.out.println("dualaddition "+operations.addition(a,b));
    }

    @Test
    public void dualsubtraction()
    {
        int a = 15;
        int b = 10;
        ArithematicOperations operations = new ArithematicOperations();
        System.out.println("dualsubtraction" + operations.subtraction(a, b));
    }

    @Test(groups = {"Smoke"})
    public void addsubtract()
    {
        ArithematicOperations operations = new ArithematicOperations();
        int a = 10;
        int b = 15;
        int c = 5;
        int sum = operations.addition(a,b);
        int result = operations.subtraction(sum, c);
        System.out.println("addsubtract" + result);
    }
}
