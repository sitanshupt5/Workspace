package com.rifle;

public class Merging {

    public static void main(String[] args)
    {
        int[] arr = {5,3,7,1,6};
        int n = arr.length;
        divide(arr,0, n-1);

        for(int i:arr)
        {
            System.out.print(i+" ");
        }
    }

    public static void divide(int arr[], int beg, int end)
    {
        if(beg>=end)
            return;

        int mid = (beg+end)/2;
        divide(arr,beg, mid);
        divide(arr, mid+1, end);
        merger(arr, beg, mid, end);
    }

    public static void merger(int[] arr, int beg, int mid, int end) {
        int merged[] = new int[end - beg + 1];
        int i1 = beg;
        int i2 = mid + 1;
        int x = 0;

        while (i1 <= mid && i2 <= end) {
            if (arr[i1] <= arr[i2])
                merged[x++] = arr[i1++];
            else
                merged[x++] = arr[i2++];
        }
        while (i1 <= mid) {
            merged[x++] = arr[i1++];
        }

        while (i2 <= end) {
            merged[x++] = arr[i2++];
        }

        for (int i = 0, j = beg; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

}
