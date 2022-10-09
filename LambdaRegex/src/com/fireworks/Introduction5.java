package com.fireworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Introduction5 {
    /*
    * In the previous examples we implemented lambda expressions for methods that do not return value.
    * In example 4 we used compare() method from the Comparator interface which returns value.
    * However, the value was being handled by sort().
    * In this example lets implement lambda expressions for method that return value and see how we can
    * handle them.
    * */

    public final static String stringOperations(UpperConcat uc, String s1, String s2)
    {
        return uc.upperAndConcat(s1,s2);
    }

    public static void main(String[] args)
    {
        Employee sitanshu = new Employee("Sitanshu", 29);
        Employee subhransu = new Employee("Subhransu", 29);
        Employee snigdha = new Employee("Snigdha",28);
        Employee suman = new Employee("Suman",27);

        List<Employee> employees = new ArrayList<>();
        employees.add(sitanshu);
        employees.add(subhransu);
        employees.add(snigdha);
        employees.add(suman);

        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        UpperConcat uc = (String s1, String s2)-> s1.toUpperCase()+s2.toUpperCase();
        String finalString = stringOperations(uc,employees.get(0).getName(),employees.get(1).getName());
        System.out.println(finalString);

        /*
        * In the above example we can see that we did not use a return statement in the lambda expression
        * for the upperAndConcat() method.
        * If we are implementing lambda expressions with single line of code for a method that returns
        * a value, the return statement is assumed.
        * Also the lambda expression here was stored in a variable object, which can be reused if necessary.
        * */
    }


}
