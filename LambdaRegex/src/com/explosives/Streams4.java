package com.explosives;

import com.dynamite.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams4 {

    /*
    * In the below example we will use flatMap() method Stream class.
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

        Department uiAutomation = new Department("Selenium");
        uiAutomation.addEmployee(sitanshu);
        uiAutomation.addEmployee(subhransu);
        uiAutomation.addEmployee(richa);

        Department apiAutomation = new Department("RestAssured");
        apiAutomation.addEmployee(arnab);
        apiAutomation.addEmployee(ashish);

        Department development = new Department("Development");
        development.addEmployee(debasish);
        development.addEmployee(snigdha);
        development.addEmployee(suman);
        development.addEmployee(abhishek);

        List<Department> departments = new ArrayList<>();
        departments.add(uiAutomation);
        departments.add(apiAutomation);
        departments.add(development);

        //Code Block 1
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("===============================================");

        //Code Block 2

        departments.stream()
                .filter(department -> department.name.equals("Development"))
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
    }

    /*
    * The flatMap() method takes a Function as an argument that returns a Stream object to the
    * flatMap().
    * The flatMap() is used to operate on nested list.
    * In the above case the list we need to operate on is the employees and not the departments.
    * As you can see we are taking the departments list as the source collection.
    * Hence in order to access the nested list employees within the source collection we use the
    * flatMap() method.
    *
    * As you can see in code block 2, we are filtering by department name and then printing the
    * employee names for the particular department.
    * */
}
