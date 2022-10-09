package com.dynamite;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfacesUsage2 {

    /*
    * In the last example we performed operations using the Consumer interface of java.util.function.
    * As we know the consumer interface does not return any value.
    * In this example lets try another interface in java.util.function that returns value.
    * The Predicate interface.
    * */

    public static void main(String[] args)
    {
        Employee sitanshu = new Employee("Sitanshu", 29);
        Employee subhransu = new Employee("Subhransu", 29);
        Employee snigdha = new Employee("Snigdha",28);
        Employee suman = new Employee("Suman",27);
        Employee abhishek =  new Employee("Abhishek", 32);
        Employee debasish = new Employee("Debasish", 30);
        Employee ashish = new Employee("Ashish", 33);
        Employee richa =  new Employee("Richa", 25);
        Employee arnab =  new Employee("Arnab", 26);

        List<Employee> employees = new ArrayList<>();
        employees.add(sitanshu);
        employees.add(subhransu);
        employees.add(snigdha);
        employees.add(suman);
        employees.add(abhishek);
        employees.add(debasish);
        employees.add(ashish);
        employees.add(richa);
        employees.add(arnab);

//      //first call
        printEmployeesNameByAge(employees, "Employees over 30:",employee -> employee.getAge()>30);
        //second call
        printEmployeesNameByAge(employees, "\nEmployees 30 and under:", employee -> employee.getAge()<=30);
        // third call
        printEmployeesNameByAge(employees, "\nEmployees under the age of 28",
                new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()<28;
            }
        });

    }

    private static void printEmployeesNameByAge(List<Employee> employees,
                                                String ageText,
                                                Predicate<Employee> ageCondition)
    {
        System.out.println(ageText);
        System.out.println("==========================================");
        for(Employee employee: employees)
        {
            if(ageCondition.test(employee))
                System.out.println(employee.getName());
        }
    }

    /*
    * The Predicate interface is a functional interface that has method called test() that lacks a
    * definition.
    * The test() method signature is such that it must return a boolean value.
    * Please refer the '3rd method call'. As you can see there we are adding implementation to the
    * test() method using an anonymous class.
    * The test() method takes employee object as an argument and verifies the condition returning
    * a boolean value to the Predicate object.
    * The object then passed to the printEmployeesNameByAge() method is evaluated for the boolean
    * value returned by the test() method over a loop.
    *
    * In the 'first call' and 'second call' we are doing the same operation, but this time using
    * lambda expression.
    * lambda expression is used for the implementation of the test() method. The lambda expression
    * body does not have a return statement as there is just single line of code.(As we know for a
    * single line of code the return keyword is assumed for lambda expressions)
    * */


}
