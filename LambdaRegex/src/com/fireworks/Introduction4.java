package com.fireworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Introduction4 {
    /*
    * In the previous example we discussed using lambda expression with zero argument list.
    * Let us try lambda expressions with multiple arguments list.
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


        /*Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });*/

        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));
        for(Employee employee: employees)
        {
            System.out.println(employee.getName());
        }

        /*
        * In the above example we are using the Comparator interface. If we look into the official
        * documentation for the Comparator interface we see that there are 2 methods that require
        * definition. 1st is the compare() method and the second is the equals() method.
        * As we know lambda expressions can be used only in case of functional interfaces that have only
        * one method that requires definition. Then how does the compiler map the definition to the
        * compare method?
        * As we know the Object class in java is the parent class of all java classes. The equals method is
        * defined inside the Object class. Hence, the equals() method in this case already has a definition.
        * Another important point to note is when we are passing multiple or no parameters in lambda argument
        * list, we need to provide it within parentheses.
        * However, if we only need to pass a single parameter in the argument list then the parentheses
        * are not necessary.
        * */
    }
}
