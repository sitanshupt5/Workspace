package com.rifle;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args)
    {
        int[] array = {5,3,7,1,6};
        int i;
        mergeSort(array,0, array.length-1);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void mergeSort(int[] array, int beg, int end) {
        int mid;
        if(beg<end)
        {
            mid = (beg+end)/2;
            mergeSort(array, beg, mid);
            mergeSort(array, mid+1, end);
            merge(array, beg, mid, end);
        }
    }

    private static void merge(int[] array, int beg, int mid, int end) {
        int i=beg, j=mid+1,k,index=beg;
        int[] temp= new int[array.length];
        while(i<=mid && j<=end){
            if(array[i]<array[j])
            {
                temp[index] = array[i];
                i++;
            }
            else
            {
                temp[index] = array[j];
                j++;
            }
            index++;
        }

        if(i>mid)
        {
            while(j<=end)
            {
                temp[index] = array[j];
                index++;
                j++;
            }
        }
        else
        {
            while(i<=mid)
            {
                temp[index] = array[i];
                index++;
                i++;
            }
        }
        k=beg;
        while(k<index)
        {
            array[k] = temp[k];
            k++;
        }
    }
}
