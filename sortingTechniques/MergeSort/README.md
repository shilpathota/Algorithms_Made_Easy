# Merge Sort
The Merge Sort algorithm is a divide-and-conquer algorithm that sorts an array by first breaking it down into smaller arrays, and then building the array back together the correct way so that it is sorted.

**Divide:** The algorithm starts with breaking up the array into smaller and smaller pieces until one such sub-array only consists of one element.

**Conquer:** The algorithm merges the small pieces of the array back together by putting the lowest values first, resulting in a sorted array.

The breaking down and building up of the array to sort the array is done recursively.

### How it works
- Divide the unsorted array into two sub-arrays, half the size of the original.
- Continue to divide the sub-arrays as long as the current piece of the array has more than one element.
- Merge two sub-arrays together by always putting the lowest value first.
- Keep merging until there are no sub-arrays left.

## Merge Sort Time Complexity
The Merge Sort algorithm breaks the array down into smaller and smaller pieces.

The array becomes sorted when the sub-arrays are merged back together so that the lowest values come first.

The array that needs to be sorted has n values, and we can find the time complexity by start looking at the number of operations needed by the algorithm.

The main operations Merge Sort does is to split, and then merge by comparing elements.

To split an array from start until the sub-arrays only consists of one value, Merge Sort does a total of n−1 splits. Just imaging an array with 16 values. It is split one time into sub-arrays of length 8, split again and again, and the size of the sub-arrays reduces to 4, 2 and finally 1. The number of splits for an array of 16 elements is 
1+2+4+8=15.
The image below shows that 15 splits are needed for an array of 16 numbers.

The number of merges is actually also n−1, the same as the number of splits, because every split needs a merge to build the array back together. And for each merge there is a comparison between values in the sub-arrays so that the merged result is sorted.
During merging of two sub-arrays, the worst case scenario that generates the most comparisons, is if the sub-arrays are equally big. Just consider merging [1,4,6,9] and [2,3,7,8]. In this case the following comparisons are needed:

Comparing 1 and 2, result: [1]
Comparing 4 and 2, result: [1,2]
Comparing 4 and 3, result: [1,2,3]
Comparing 4 and 7, result: [1,2,3,4]
Comparing 6 and 7, result: [1,2,3,4,6]
Comparing 9 and 7, result: [1,2,3,4,6,7]
Comparing 9 and 8, result: [1,2,3,4,6,7,8]
At the end of the merge, only the value 9 is left in one array, the other array is empty, so no comparison is needed to put the last value in, and the resulting merged array is [1,2,3,4,6,7,8,9]. We see that we need 7 comparisons to merge 8 values (4 values in each of the initial sub-arrays). In general, in a worst case scenario, 
n−1 comparisons are needed to get a merged array of n values.
For simplicity, let's say that we need n comparisons instead of n−1 when merging n values. This is an ok assumption when n is large and we want to calculate an upper bound using Big O notation.
So, at each level merging happens, n comparisons are needed, but how many levels are there? Well, for n=16 we have n=16=2^4, so 4 levels of merging. For n=32=2^5
 there are 5 levels of merging, and at each level, n comparisons are needed. For n=1024=2^10 10 levels of merging is needed. To find out what power of 2 gives us 1024, we use a base-2 logarithm. The answer is 10. Mathematically it looks like this: log2(1024)=10.
Merging elementsAs we can see from the figure above, n comparisons are needed on each level, and there are log2n levels, so there are n⋅log2n comparison operations in total.
Time complexity can be calculated based on the number of split operations and the number of merge operations:O((n−1)+nlog2n)=O(n⋅log2n)
The number of splitting operations (n−1) can be removed from the Big O calculation above because n⋅log2n will dominate for large n, and because of how we calculate time complexity for algorithms.
The figure below shows how the time increases when running Merge Sort on an array with n values.

**Time Complexity**
The difference between best and worst case scenarios for Merge Sort is not as big as for many other sorting algorithms.
