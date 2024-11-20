# Selection Sort
The Selection Sort algorithm finds the lowest value in an array and moves it to the front of the array.

The algorithm looks through the array again and again, moving the next lowest values to the front, until the array is sorted.

### How it works
- Go through the array to find the lowest value.
- Move the lowest value to the front of the unsorted part of the array.
- Go through the array again as many times as there are values in the array.

### Psuedo code
<pre>
  function selection_sort(array):
    m = length(array)
    for i = 0 to m-2:
        # Assume the current index (i) has the minimum value
        min_index = i
        # Find the minimum element in the remaining unsorted part
        for j = i + 1 to m-1:
            if array[j] < array[min_index]:
                min_index = j
        # Swap the found minimum element with the first element of the unsorted part
        swap(array[i], array[min_index])
</pre>

As you observe, by the time we complete the inner loop, you find the index of minimum value and on coming out we exchange the value with the first element and it continues. This adds complexity as you see the inner loop runs atleast for n/2 times which means the outer loop n times leads to O(n^2) complexity.


