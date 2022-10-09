package com.revolver;

import java.util.Scanner;

public class Question25 {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the number of rows");
        int rows = scan.nextInt();
        scan.close();
        int alphabet = 65;
        for (int i =0; i<rows; i++)
        {
            for(int j=rows-i;j>= 1; j--)
                System.out.print(" ");

            for(int k=i; k>=0; k--)
                System.out.print((char)(alphabet+k));

            for(int l=1; l<=i; l++)
                System.out.print((char)(alphabet+l));

            System.out.println();
        }

        for (int i =rows-2; i>=0; i--)
        {
            for(int j=rows-i;j>= 1; j--)
                System.out.print(" ");

            for(int k=i; k>=0; k--)
                System.out.print((char)(alphabet+k));

            for(int l=1; l<=i; l++)
                System.out.print((char)(alphabet+l));

            System.out.println();
        }
    }
}
