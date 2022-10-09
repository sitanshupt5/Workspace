package com.fireworks;

import java.util.ArrayList;
import java.util.List;

public class LambdaScope2 {

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

        for(Employee employee:employees)
        {
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start();
        }

        /*
        * Code Snippet 2:
        Employee employee;
        for(int i=0; i< employees.size(); i++)
        {
            employee = employees.get(i);
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start();
        }*/

        /*
        * Code using iterable.forEach()
        * */
        System.out.println("********************************************************************");

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }

    /*
    * If we intend to use a variable declared and initialised outside the lambda, inside the lambda,
    * the said variable needs to be effectively final. That is either it must be declared as final or
    * its value must never be changed. If the variable is not declared as final then the compiler complains.
    * The above behavior is same as that of nested code blocks.
    *
    * In the above code as we can see the lambda expression has been placed under the enhanced for loop
    * and used the employee variable whose value keeps changing.
    * Then why doesn't the compiler throw error?
    * It is because the employee variable is effectively final for the instance of the iteration.
    *
    * But refer to the commented segment of the code. In this case the employee object is declared
    * outside the loop and is being constantly updated. In this case the compiler will throw error
    * as it is not effectively final(its value has been updated atleast once)
    * */

}
