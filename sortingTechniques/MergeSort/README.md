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

