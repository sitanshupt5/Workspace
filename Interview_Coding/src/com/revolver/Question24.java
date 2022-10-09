package com.revolver;

import java.util.Scanner;

/*
* Write a program to print the following pattern of alphabets
*     A
*    A B
*   A B C
*  A B C D
* A B C D E
* */

public class Question24 {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the number of rows");
        int rows = scan.nextInt();
        scan.close();
        int alphabet = 65;
        for (int i = 0; i<rows; i++)
        {
            for (int j =rows-i; j>=1; j--)
                System.out.print(" ");

            for(int j=0; j<=i; j++)
                System.out.print((char)(alphabet+j)+" ");

            System.out.println();
        }
    }
}
