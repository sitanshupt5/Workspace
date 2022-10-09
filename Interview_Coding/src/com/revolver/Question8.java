package com.revolver;

/*
 * Write a program to find the 3rd highest number in an array.
 * */

public class Question8 {

    public static void main(String[] args)
    {
        int[] array = {6,5,4,3,2,1};
        for(int i = 0; i<array.length-1; i++)
        {
            for(int j =i+1; j<array.length; j++)
            {
                if(array[i]>array[j])
                {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }

        for(int i = 0; i<array.length; i++)
        {
            System.out.print(array[i]+", ");
        }

        System.out.println("3rd largest number is "+array[array.length-3]);
    }
}
