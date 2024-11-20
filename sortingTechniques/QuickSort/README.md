# Quick Sort
As the name suggests, this is one of the quickest algorithms. The logic behind this sorting technique is selecting the pivot element and the numbers on the left are less than the pivot and the numbers on the right are greater than the pivot element.

This follows Divide and Conquer approach where you select the pivot and divide the remaining elements into 2 subarrays. 1 subarray will have all the elements that are less than or equal to the pivot element and the elements in the other subarray is greater than the pivot element.

The process is recursively followed to all the subarrays and then the result is combined to get the sorted array.

The worst case scenario is O(n^2) where selected pivot is largest or smallest and it has to recursively exchange in eveyr iteration. But most of the times it gives O(nlog n) which is the optimized value.

## Logic behind the Sorting
In this algorithm, the key would be selecting the pivot element.
Consider the array {5, 3, 4, 6, 5, 9}
- Let’s suppose we pick 5 as the pivot for simplicity
- We’ll first put all elements less than 5 in the first position of the array: {3, 4, 5, 6, 5, 9}
- We’ll then repeat it for the left sub-array {3,4}, taking 3 as the pivot
- There are no elements less than 3
- We apply quicksort on the sub-array in the right of the pivot, i.e. {4}
- This sub-array consists of only one sorted element
- We continue with the right part of the original array, {6, 5, 9} until we get the final ordered array

## Code behind the Sorting
For this first step is to define the quicksort algorithm which divides the array into 2 sub arrays
<pre>
  public void quickSort(int arr[], int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);

        quickSort(arr, begin, partitionIndex-1);
        quickSort(arr, partitionIndex+1, end);
    }
}
</pre>
As you can see the partition is crucial and where the logic resides
<pre>
  private int partition(int arr[], int begin, int end) {
    int pivot = arr[end];
    int i = (begin-1);

    for (int j = begin; j < end; j++) {
        if (arr[j] <= pivot) {
            i++;

            int swapTemp = arr[i];
            arr[i] = arr[j];
            arr[j] = swapTemp;
        }
    }

    int swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;

    return i+1;
}
</pre>

In the best case, the algorithm will divide the list into two equal size sub-lists. So, the first iteration of the full n-sized list needs O(n). Sorting the remaining two sub-lists with n/2 elements takes 2*O(n/2) each. As a result, the QuickSort algorithm has the complexity of O(n log n).


In the worst case, the algorithm will select only one element in each iteration, so O(n) + O(n-1) + … + O(1), which is equal to O(n2).

On the average QuickSort has O(n log n) complexity, making it suitable for big data volumes.
