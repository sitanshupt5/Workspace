package com.revolver;

/*
* Write a program to print the following pattern in console.
*
* 5 4 3 2 1 2 3 4 5
*   4 3 2 1 2 3 4
*     3 2 1 2 3
*       2 1 2
*         1
* */

import java.util.Scanner;

public class Question22 {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = scan.nextInt();
        scan.close();

        for (int i =rows; i>=1; i--)
        {
            for(int j=rows-i;j>= 1; j--)
                System.out.print(" ");

            for(int k=i; k>=1; k--)
                System.out.print(k);

            for(int l=2; l<=i; l++)
                System.out.print(l);

            System.out.println();
        }
    }
}
