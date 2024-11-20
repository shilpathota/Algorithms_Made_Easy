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

### Worst Case Complexity: O(n2)
Suppose, an array is in ascending order, and you want to sort it in descending order. In this case, worst case complexity occurs.

Each element has to be compared with each of the other elements so, for every nth element, (n-1) number of comparisons are made.

Thus, the total number of comparisons = n*(n-1) ~ n2
### Best Case Complexity: O(n)
When the array is already sorted, the outer loop runs for n number of times whereas the inner loop does not run at all. So, there are only n number of comparisons. Thus, complexity is linear.
### Average Case Complexity: O(n2)
It occurs when the elements of an array are in jumbled order (neither ascending nor descending).
### Space Complexity

Space complexity is O(1) because an extra variable key is used.

The insertion sort is used when:

the array is has a small number of elements
there are only a few elements left to be sorted
