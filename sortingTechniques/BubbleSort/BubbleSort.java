package org.example;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] ele){
        // 2 iterations
        // 1 iteration the highest element is bubbled up to the last
        // outer loop traverse through all elements
        //Optimizations: 1. Remove the last element from the iteration as it is already palced 2 . if already sorted without swap,then loop stops
        //BRuteForce

        long startTime = System.nanoTime();
        for(int i=0;i<ele.length;i++){
            for(int j=i+1;j<ele.length;j++){
                if(ele[i]>ele[j]){
                    int temp = ele[i];
                    ele[i]=ele[j];
                    ele[j]=temp;
                }
            }
        }
        long stopTime = System.nanoTime();
        System.out.println("Time Taken to execute:"+
                (stopTime - startTime) +" milliseconds");

        System.out.println("After Sorted: "+Arrays.toString(ele));
    }
    public static void OptimizedbubbleSort(int[] ele){
        // 2 iterations
        // 1 iteration the highest element is bubbled up to the last
        // outer loop traverse through all elements
        //Optimizations: 1. Remove the last element from the iteration as it is already palced 2 . if already sorted without swap,then loop stops
        //BRuteForce
        Boolean swapped = false;
        long startTime = System.nanoTime();
        for(int i=0;i<ele.length;i++){
            swapped = false;
            for(int j=i+1;j<ele.length-i;j++){
                if(ele[i]>ele[j]){
                    int temp = ele[i];
                    ele[i]=ele[j];
                    ele[j]=temp;
                    swapped=true;
                }

            }
            if(!swapped){
                break;
            }
        }
        long stopTime = System.nanoTime();
        System.out.println("Time Taken to execute:"+
                (stopTime - startTime) +" milliseconds");

        System.out.println("After Sorted: "+Arrays.toString(ele));
    }
    public static int[] optimizedCodeBubbleSort(int[] input) {
        long startTime = System.nanoTime();
        boolean swapped = true;
        for (int pass = input.length - 1; pass >= 0 && swapped; pass--) {
            swapped = false;
            for (int i = 0; i < pass; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        System.out.println("Time taken for OPTIMIZED bubbleSort: "
                + (System.nanoTime() - startTime));
        return input;
    }

    public static void bubbleSort_withFlag(int[] intArr) {
        long startTime = System.nanoTime();

        int lastComparison = intArr.length - 1;

        for (int i = 1; i < intArr.length; i++) {
            boolean isSorted = true;
            int currentSwap = -1;
            for (int j = 0; j < lastComparison; j++) {
                if (intArr[j] < intArr[j + 1]) {
                    int tmp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = tmp;
                    isSorted = false;
                    currentSwap = j;
                }

            }
            if (isSorted) return;
            lastComparison = currentSwap;
        }
        System.out.println("Time taken for with Flag bubbleSort: "
                + (System.nanoTime() - startTime));
    }
}
