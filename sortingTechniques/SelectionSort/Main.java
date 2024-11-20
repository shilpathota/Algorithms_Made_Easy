package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] generateRandomNumbers(int n){
        int[] arr = new int[n];

        // Create a Random object
        Random random = new Random();

        // Assign random values to the array
        for (int i = 0; i < n; i++) {

            // Generate a random integer
            // between INT_MIN and INT_MAX
            arr[i] = random.nextInt(1000);
        }

        // Print the array
        System.out.println("Before Sorted:"+Arrays.toString(arr));
        return arr;
    }

    //Selection Sort
        public static void main(String[] args) {

        int[] arra=generateRandomNumbers(90);
        Arrays.sort(arra);
        SelectionSort.selectionSort(arra);
        SelectionSort.optimizedselectionSort(arra);
    }
}
