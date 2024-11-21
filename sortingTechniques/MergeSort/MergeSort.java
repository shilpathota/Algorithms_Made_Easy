package org.example;

import java.util.Arrays;

public class MergeSort {
    //merge
    //divide
    public static void merge(int[] arr,int low,int high,int middle){
            int n1 = middle - low + 1;
            int n2 = high - middle;
        System.out.println("n1:"+n1+",,n2:"+n2);
            int[] arr1 = new int[n1];
            int[] arr2 = new int[n1];

            for (int i = 0; i < n1; i++) {
                arr1[i] = arr[low+i];
            }
            for (int i = 0; i < n2; i++) {
                arr2[i] = arr[i + middle + 1];
            }
            System.out.println("Arr1:"+Arrays.toString(arr1));
        System.out.println("Arr2:"+Arrays.toString(arr2));
            int i=0,j=0;

            int k=low;

            while(i<n1 && j <n2){
                    if(arr1[i]<arr2[j]){
                        arr[k]=arr1[i];
                        i++;
                        k++;
                    }else if(arr2[j]<arr1[i]){
                        arr[k]=arr2[j];
                       j++;
                       k++;
                }
            }
            while(i<n1){
                arr[k]=arr1[i];
                k++;
                i++;
            }
        while(j<n2){
            arr[k]=arr2[j];
            k++;
            j++;
        }
        System.out.println("Arr"+Arrays.toString(arr));
    }
    public static void dividevalue(int[] arr,int l,int r){
        if(l<r){
            int m=l+((r-l)/2);
            dividevalue(arr,0,m);
            dividevalue(arr,m+1,r);

            merge(arr,l,r,m);
        }
    }
    //sort
    public static void mergesort(int[] arr){
        long startTime = System.nanoTime();

        dividevalue(arr,0,arr.length-1);
        long stopTime = System.nanoTime();

        System.out.println("Time Taken to execute:"+
                (stopTime - startTime) +" milliseconds");
        Arrays.stream(arr).forEach(System.out::print);
    }
}
