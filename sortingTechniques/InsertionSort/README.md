# Insertion Sort
The Insertion Sort algorithm uses one part of the array to hold the sorted values, and the other part of the array to hold values that are not sorted yet.


The algorithm takes one value at a time from the unsorted part of the array and puts it into the right place in the sorted part of the array, until the array is sorted.

### How it works
- Take the first value from the unsorted part of the array.
- Move the value into the correct place in the sorted part of the array.
- Go through the unsorted part of the array again as many times as there are values.

### Pseudo Code
<pre>
  
insertionSort(array)
  mark first element as sorted
  for each unsorted element X
    'extract' the element X
    for j <- lastSortedIndex down to 0
      if current element j > X
        move sorted element to the right by 1
    break loop and insert X here
end insertionSort
      
</pre>

As you can see the key is the current element and if the element is inserted into the elements below it where it fits by comparing with the elements lower than that.
