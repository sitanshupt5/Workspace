package com.fireworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Introduction6 {
    /*
    * In the previous lambda example we implemented lambda expressions with a single line of code.
    * Lets try implementing lambda expressions for multiple line code block.
    * */
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

        UpperConcat uc = (s1,s2) ->{
            String result = s1.toUpperCase()+s2.toUpperCase();
            return result;
        };
        String finalString = stringOperations(uc,employees.get(0).getName(),employees.get(1).getName());
        System.out.println(finalString);
    }

    public final static String stringOperations(UpperConcat uc, String s1, String s2)
    {
        return uc.upperAndConcat(s1,s2);
    }

    /*
    * In the above example we have used a multiple line code block in the body of the lambda exp.
    * If we have more than one line of code in the body, they have to be placed within curly braces.
    * Individual lines of code must end with a semicolon (;).
    * If the method implementing lambda has more than one line of code and has to return a value,
    * the return statement is not assumed, it has to be mentioned explicitly.
    * */
}
