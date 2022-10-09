package com.hypo;

import java.util.Scanner;

public class Conditions {
    /*
    * if-else clauses
    * */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your operation\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
        String operation = scanner.nextLine();
        int a =20; int b= 40;
        if(operation.equals("Addition")) {
            System.out.println("Sum is="+(a+b));
        }
        else if(operation.equals("Subtraction"))
            System.out.println("Difference is ="+(a-b));
        else if(operation.equals("Multiplication"))
            System.out.println("Product is="+(a*b));
        else if(operation.equals("Division")){
            System.out.println("Dividend is="+(a/b));
        System.out.println("End");}

    }
}
