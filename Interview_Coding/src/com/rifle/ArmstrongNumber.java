package com.rifle;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {


        for (int j=10; j < 1000;j++) {

            int product = 0;
            int i = j;

            while (i % 10 != 0) {
                product = product + (int) Math.pow(i % 10, 3);
                i = i / 10;
            }

            if (product == j)
                System.out.println(j + " is an Armstrong number");
        }
    }
}
