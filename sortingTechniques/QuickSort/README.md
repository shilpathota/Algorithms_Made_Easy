# Quick Sort
As the name suggests, this is one of the quickest algorithms. The logic behind this sorting technique is selecting the pivot element and the numbers on the left are less than the pivot and the numbers on the right are greater than the pivot element.

This follows Divide and Conquer approach where you select the pivot and divide the remaining elements into 2 subarrays. 1 subarray will have all the elements that are less than or equal to the pivot element and the elements in the other subarray is greater than the pivot element.

The process is recursively followed to all the subarrays and then the result is combined to get the sorted array.

The worst case scenario is O(n^2) where selected pivot is largest or smallest and it has to recursively exchange in eveyr iteration. But most of the times it gives O(nlog n) which is the optimized value.

## Logic behind the Sorting
In this algorithm, the key would be selecting the pivot element.

