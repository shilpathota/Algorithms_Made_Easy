package org.example;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        long startTime = System.nanoTime();

        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && key < arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        long stopTime = System.nanoTime();
        System.out.println("Time Taken to execute:"+
                (stopTime - startTime) +" milliseconds");
        System.out.println("After Sorted: "+Arrays.toString(arr));
    }
}
