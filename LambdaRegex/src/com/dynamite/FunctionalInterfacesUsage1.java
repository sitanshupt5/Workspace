package com.dynamite;

import com.fireworks.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalInterfacesUsage1 {

    /*
    * Java 8 introduced java.utils.functions package that contains functional interfaces that can be
    * used alongside lambda expressions.
    * */

    public static void main(String[] args)
    {
        com.fireworks.Employee sitanshu = new com.fireworks.Employee("Sitanshu", 29);
        com.fireworks.Employee subhransu = new com.fireworks.Employee("Subhransu", 29);
        com.fireworks.Employee snigdha = new com.fireworks.Employee("Snigdha",28);
        com.fireworks.Employee suman = new com.fireworks.Employee("Suman",27);

        List<com.fireworks.Employee> employees = new ArrayList<>();
        employees.add(sitanshu);
        employees.add(subhransu);
        employees.add(snigdha);
        employees.add(suman);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        /*employees.forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee.getName());
                System.out.println(employee.getAge());
            }
        });*/
    }

    /*
    * In the above implementation we are using the forEach() method to iterate. The forEach() method
    * in turn uses an implementation for the accept() method declared in java.util.function.Consumer
    * interface.
    * The forEach method takes Consumer<T> action object. We provide forEach() with a lambda expression
    * that meets the requirement of the Consumer interface. A Consumer accepts one argument and
    * performs an action that doesn't return a value.
    * Its called a Consumer because it is object in and nothing out. This serves perfectly when we
    * need to perform an operation like iterate over a list or print the contents.
    *
    * Now coming back to our code we can see the lambda expression we are passing in the forEach()
    * method meets its expectation as it takes an Employee object and doesn't return anything(Matching
    * the description of a Consumer)
    *
    * When we call forEach() it iterates over the list. For each iteration it calls the Consumer's
    * accept() method passing the employee object as the parameter argument.
    * The accept() method evaluates the lambda expression with the passed employee object as the argument.
    * The employee's name and age are printed to the console and nothing is returned.
    *
    * Refer to the commented code block. It does effectively the same operation done by the lambda
    * expression.
    * The accept() method takes an Employee object as an argument and does not return any value.
    * */
}
