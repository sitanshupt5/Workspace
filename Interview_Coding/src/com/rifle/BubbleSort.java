package com.rifle;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args)
    {
        int[] array = {5,3,7,1,8,2,0,9};

        bubbleSort(array);
    }

    private static void bubbleSort(int[] array) {

        for (int k=1; k< array.length-1; k++)
        {

            for (int i=0; i< array.length-k-1; i++)
            {
                if (array[i]>array[i+1])
                {
                    int x = array[i];
                    array[i]=array[i+1];
                    array[i+1]=x;

                }
            }

        }
        Arrays.stream(array).forEach(System.out::println);
    }
}
