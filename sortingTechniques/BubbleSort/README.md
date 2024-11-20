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

Even though we optimize the code, it still has more time complexity and worst case has O(n^2)


There are better algorithms that does the job even faster and effecient.

## Results of Experiments conducted
I have used 4 methods where I have used some optimization techniques and noted the time taken for each of the technique. Here are the results when sorted and not sorted
### Sorted Results
I have sent the array which is already sorted and calcullated the time for 90 records of values which is randomly generated and the numbers are between 0 - 1000

<pre>
Time Taken to execute:53900 milliseconds
After Sorted: [8, 16, 25, 27, 44, 56, 70, 75, 92, 96, 105, 108, 114, 116, 120, 120, 133, 137, 164, 193, 198, 204, 211, 213, 224, 246, 287, 291, 299, 299, 321, 329, 333, 345, 346, 364, 373, 389, 393, 398, 405, 423, 442, 501, 515, 517, 535, 537, 557, 565, 582, 589, 609, 632, 655, 664, 693, 693, 704, 726, 733, 734, 765, 765, 765, 768, 807, 810, 817, 820, 822, 831, 844, 845, 863, 874, 886, 893, 894, 898, 907, 915, 925, 931, 955, 961, 965, 982, 989, 992]
Time Taken to execute:2500 milliseconds
After Sorted: [8, 16, 25, 27, 44, 56, 70, 75, 92, 96, 105, 108, 114, 116, 120, 120, 133, 137, 164, 193, 198, 204, 211, 213, 224, 246, 287, 291, 299, 299, 321, 329, 333, 345, 346, 364, 373, 389, 393, 398, 405, 423, 442, 501, 515, 517, 535, 537, 557, 565, 582, 589, 609, 632, 655, 664, 693, 693, 704, 726, 733, 734, 765, 765, 765, 768, 807, 810, 817, 820, 822, 831, 844, 845, 863, 874, 886, 893, 894, 898, 907, 915, 925, 931, 955, 961, 965, 982, 989, 992]
Time taken for OPTIMIZED bubbleSort: 1600
Time taken for with Flag bubbleSort: 110900
</pre>
### Unsorted Results
I have given random values between 0 - 1000 and not sorted them
<pre>
  Before Sorted:[782, 479, 978, 120, 176, 268, 822, 493, 279, 974, 102, 788, 84, 47, 531, 928, 384, 719, 351, 519, 329, 51, 998, 879, 484, 207, 605, 645, 628, 265, 183, 620, 72, 692, 775, 430, 571, 541, 735, 625, 525, 638, 679, 313, 439, 917, 497, 46, 860, 80, 40, 450, 811, 471, 313, 169, 712, 869, 274, 981, 186, 133, 168, 973, 639, 69, 836, 946, 996, 785, 389, 766, 721, 367, 217, 81, 921, 771, 844, 417, 895, 847, 636, 317, 147, 792, 107, 918, 340, 927]
Time Taken to execute:78000 milliseconds
After Sorted: [40, 46, 47, 51, 69, 72, 80, 81, 84, 102, 107, 120, 133, 147, 168, 169, 176, 183, 186, 207, 217, 265, 268, 274, 279, 313, 313, 317, 329, 340, 351, 367, 384, 389, 417, 430, 439, 450, 471, 479, 484, 493, 497, 519, 525, 531, 541, 571, 605, 620, 625, 628, 636, 638, 639, 645, 679, 692, 712, 719, 721, 735, 766, 771, 775, 782, 785, 788, 792, 811, 822, 836, 844, 847, 860, 869, 879, 895, 917, 918, 921, 927, 928, 946, 973, 974, 978, 981, 996, 998]
Time Taken to execute:2600 milliseconds
After Sorted: [40, 46, 47, 51, 69, 72, 80, 81, 84, 102, 107, 120, 133, 147, 168, 169, 176, 183, 186, 207, 217, 265, 268, 274, 279, 313, 313, 317, 329, 340, 351, 367, 384, 389, 417, 430, 439, 450, 471, 479, 484, 493, 497, 519, 525, 531, 541, 571, 605, 620, 625, 628, 636, 638, 639, 645, 679, 692, 712, 719, 721, 735, 766, 771, 775, 782, 785, 788, 792, 811, 822, 836, 844, 847, 860, 869, 879, 895, 917, 918, 921, 927, 928, 946, 973, 974, 978, 981, 996, 998]
Time taken for OPTIMIZED bubbleSort: 1600
Time taken for with Flag bubbleSort: 113100
</pre>

From the results I see huge difference between bruteforce and the optimized technique where I have focused on 2 optimization techniques which are
- Removing the last number as it is already bubbled up in the iteration 1 for the rest of iteractions
- If the swapping is stopped which means the array is already sorted, it breaks the loop and stops the execution.

