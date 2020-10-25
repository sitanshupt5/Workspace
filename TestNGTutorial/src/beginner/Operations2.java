package beginner;

import org.testng.annotations.Test;

public class Operations2 {

    @Test
    public void dualproduct()
    {
        ArithematicOperations operations = new ArithematicOperations();
        int a = 10;
        int b = 5;
        System.out.println("Dual product " + (operations.multiplication(a,b)));
    }

    @Test(dependsOnMethods = {"dualproduct"})
    public void dualdivision()
    {
        ArithematicOperations operations =  new ArithematicOperations();
        int a = 100;
        int b = 10;
        System.out.println("Dual division " + (operations.division(a,b)));
    }
}
