# Bubble Sort
This is the sorting technique where the numbers are sorted in ascending or descending order

## Logic Involved
We have to compare the first 2 values and swap if the first element is bigger than the second element.<br/>
This process is repeated until we go to the end of the array elements.<br/>
By that time, we reach the last element we observe that the bigger number is bubbled up to the last.<br/>
In each iteration, we repeat this process and so the highest numbers are sorted.

This process involves 2 loops where outer loop iterates till the last element and inner loop bubbles up the bigger number to the last.
## Optimize the Logic
The bubble sort algorithm can be easily optimized by observing that the n-th pass finds the n-th largest element and puts it into its final place. So, the inner loop can avoid looking at the last n − 1 items when running for the n-th time.


### Track swaps
Use a flag to check if any swaps were made in the last pass. If no swaps were made, the list is sorted and no more passes are needed. This can reduce the worst-case time complexity of bubble sort from O(n^2) to O(n). 
### Reduce the area of comparison
Start with the maximum length of the array and decrement it by one after each pass. This avoids comparing with the last elements of the array on each pass, which are already in their correct position. 
### Only compare adjacent elements
After each pass of the outer loop, the largest element in the unsorted subarray will be bubbled to the end of the array. This allows you to skip comparing elements that are already sorted. 


## Optimized code
<pre>
  public static Integer[] optimizedBubbleSort(Integer[] input) {
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
</pre>
In the above code, you use the flag swapped to determine if the values are swapped in the inner loop. If we do not swap then it means the numbers are already sorted and so it exits the loop.
<pre>
  public static void bubbleSort_withFlag(Integer[] intArr) {
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
    } 
</pre>
This is adding the lastComparison value where the inner loop skips the comparison of the last element which is already bubbled up and placed in the correct place.
