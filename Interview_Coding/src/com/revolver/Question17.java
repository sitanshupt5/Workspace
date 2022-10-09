package com.revolver;

import java.util.Scanner;

/*
* Write a program to print the following right triangle structure:
*  *
*  * *
*  * * *
*  * * * *
*  * * * * *
* */

public class Question17 {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the number of rows");
        int rows = scan.nextInt();
        scan.close();
        for (int i = 0; i<rows; i++)
        {
            for(int j=0; j<=i; j++)
                System.out.print("* ");

            System.out.println();
        }
    }
}
