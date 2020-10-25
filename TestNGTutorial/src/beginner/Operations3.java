package beginner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Operations3 {

    @Parameters({"number1","number2"})
    @Test
    public void squareOfAPlusB(int a, int b)
    {
        ArithematicOperations operations = new ArithematicOperations();
        int square = operations.square(a) + operations.square(b) + 2*(operations.addition(a,b));
        System.out.println(square);
    }

    @Parameters({"number1", "number2"})
    @Test(groups = {"Smoke"})
    public void cubeOfAPlusB(int a, int b)
    {
        ArithematicOperations operations =  new ArithematicOperations();
        int cube = operations.cube(a) + operations.cube(b) + 3*((operations.square(a))*b) + 3*((operations.square(b))*a);
        System.out.println(cube);
    }


}
