package com.dynamite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FunctionalInterfacesUsage4 {
    /*
    * In the previous examples we have used different functional interfaces available under the
    * java.util.function package namely Consumer, Predicate, Supplier and the variants of Predicate
    * and Supplier interfaces.
    *
    * Lets we need to use a lambda expression that can accept any value as argument and return us
    * a value, both of whose types are user defined. In such a case Consumer does not return any
    * values, Predicate only returns a boolean value and Supplier does not accept any arguments.
    * So none of the previously used interfaces meet our requirements here.
    *
    * However we have another interface called the Function interface that accepts user defined
    * arguments and returns a user defined value type.
    * Lets check that out.
    * */

    public static void main(String[] args)
    {
        Employee sitanshu = new Employee("Sitanshu Pati", 29);
        Employee subhransu = new Employee("Subhransu Nayak", 29);
        Employee snigdha = new Employee("Snigdha Mahapatra",28);
        Employee suman = new Employee("Suman Pani",27);
        Employee abhishek =  new Employee("Abhishek Dash", 32);
        Employee debasish = new Employee("Debasish Diptiranjan", 30);
        Employee ashish = new Employee("Ashish Patra", 33);
        Employee richa =  new Employee("Richa Sharma", 25);
        Employee arnab =  new Employee("Arnab Das", 26);

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

        //Code Block 1

        Function<Employee, String> getLastName = employee ->
                employee.getName().substring(employee.getName().indexOf(" ")+1);

        /*Function<Employee, String> lastname = new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName().substring(employee.getName().indexOf(" ")+1);
            }
        };*/

        //Code Block 2
        Function<Employee, String> getFirstName = employee ->
                employee.getName().substring(0, employee.getName().indexOf(" "));

        //Code Block 3

        Random random1 = new Random();
        for (Employee employee:employees)
        {
            if (random1.nextBoolean())
                System.out.println("First name is: "+ getAName(getFirstName,employee));
            else
                System.out.println("Last name is: "+getAName(getLastName,employee));
        }
    }

    private static String getAName(Function<Employee, String> getName, Employee employee)
    {
        return getName.apply(employee);
    }

    /*
    * In the above case refer to code block 1.
    * Here we are using the Function interface where we are passing 2 parameters  inside the '<>'.
    * The first parameter is the argument for the apply() method. The second parameter decides the
    * return type for the apply() method. Refer to the commented code block for the implementation
    * using anonymous class.
    * The code block 2 defines a similar object as code block 1 but for the purpose of extracting the
    * first name.
    *
    * Code block 3 makes a random call to getAName() method which accepts the Function object and
    * an employee object to return a value.
    *
    * In the above case we avoided creating a third object for extracting both the first name and
    * the last name. We used the existing lambda expressions defined for extracting first name and
    * last name.
    * This is the advantage of the Function interface. Lets suppose an example.
    * Suppose we need to perform operations on a data in 4 steps.
    * Step 1 can be done in 3 ways depending on the conditions.
    * Step 2 can be done in 2 ways.
    * Step 3 can be done in 4 ways.
    * Step 4 can be done in 3 ways.
    *
    * So in order for all the combinations to be covered we will need to define about
    * 3*2*4*3 = 72 methods altogether. That can be our first approach.
    * The 2nd approach could be defining 12 lambda expressions and using them based on the
    * condition.
    * Obviously the second method will be easier and less time consuming. Also, the number of
    * lines of code will reduce drastically.
    * */
}
