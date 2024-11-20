package org.example;

import java.util.Arrays;

public class SelectionSort {
    static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void selectionSort(int[] arr){
        long startTime = System.nanoTime();

        for(int i=0;i<arr.length;i++){
            int min_index = i;
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[min_index]>arr[j]){
                    min_index=j;
                }
            }
            swap(arr,min_index,i);
        }
        long stopTime = System.nanoTime();
        System.out.println("Time Taken to execute:"+
                (stopTime - startTime) +" milliseconds");
        System.out.println("After Sorting: "+Arrays.toString(arr));
    }
    public static void optimizedselectionSort(int[] arr){
        long startTime = System.nanoTime();

        for(int i=0;i<arr.length;i++){
            int min_index = i;
            int max_index=i;
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[min_index]>arr[j]){
                    min_index=j;
                }
                if(arr[max_index]<arr[j]){
                    max_index=j;
                }
            }
            swap(arr,min_index,i);

            if(arr[min_index]==arr[max_index]){
                swap(arr,arr.length-1,min_index);
            }else{
                swap(arr,arr.length-1,max_index);
            }
        }
        long stopTime = System.nanoTime();
        System.out.println("Time Taken to execute:"+
                (stopTime - startTime) +" milliseconds");
        System.out.println("After Sorting: "+Arrays.toString(arr));
    }
}
