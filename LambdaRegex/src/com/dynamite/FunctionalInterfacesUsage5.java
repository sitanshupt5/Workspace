package com.dynamite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterfacesUsage5 {
    /*
    * In the previous example we understood how to use the Function interface. This example lets
    * try out some of the other features of the Function interface.
    * lambdas for the Function interface can be chained together just like the Predicate. This can be
    * done using the andThen() method.
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

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));

        //Code Block 1
        Function chainedFunction = upperCase.andThen(firstName);

        //Code Block 2
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) ->
                name.concat(" "+employee.getAge());


        for (Employee employee: employees)
        {
            String firstname = chainedFunction.apply(employee).toString();
            System.out.println("First name and Age is: "+ concatAge.apply(firstname,employee));
        }

        /*
        * As we can see above we have chained 2 lambda functions using the andThen() method.
        * The chained function first executes the upperCase lambda and the executes the firstName.
        *
        * Coming down to the code block 2. Here we have used the BiFunction interface. The
        * Bi-interfaces exist for Predicates and Function. The BiFunction interfaces accepts two
        * arguments unlike the normal Function interface which accepts only one.
        * Since BiFunction interface accepts 2 arguments it can be chained another lambda.
        * As we for the andThen() passes the return value of the first lambda as argument in the
        * second lambda. BiFunction interface lambda has 2 arguments there will be ambiguity in
        * mapping the return value to the arguments.
        * However, the BiFunction lambda can be chained as the first lambda as the supplier.
        * */
    }




}
