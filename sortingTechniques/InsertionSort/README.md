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

### My Experiment
When executed these are the time taken for 90 numbers between 1 - 1000
<pre>
 Before Sorted:[572, 896, 6, 676, 259, 294, 226, 187, 2, 157, 742, 87, 970, 595, 232, 651, 535, 588, 377, 75, 239, 374, 880, 623, 785, 347, 393, 313, 162, 708, 277, 875, 562, 447, 139, 426, 141, 861, 412, 1, 150, 579, 804, 316, 206, 722, 956, 498, 90, 181, 909, 605, 178, 63, 191, 290, 102, 982, 415, 103, 155, 88, 279, 894, 267, 904, 223, 477, 187, 13, 513, 222, 606, 400, 522, 90, 710, 503, 181, 885, 290, 523, 369, 574, 763, 242, 955, 670, 177, 450]
Time Taken to execute:34100 milliseconds
After Sorted: [1, 2, 6, 13, 63, 75, 87, 88, 90, 90, 102, 103, 139, 141, 150, 155, 157, 162, 177, 178, 181, 181, 187, 187, 191, 206, 222, 223, 226, 232, 239, 242, 259, 267, 277, 279, 290, 290, 294, 313, 316, 347, 369, 374, 377, 393, 400, 412, 415, 426, 447, 450, 477, 498, 503, 513, 522, 523, 535, 562, 572, 574, 579, 588, 595, 605, 606, 623, 651, 670, 676, 708, 710, 722, 742, 763, 785, 804, 861, 875, 880, 885, 894, 896, 904, 909, 955, 956, 970, 982]
 
</pre>
What if the array is already sorted
<pre>
Time Taken to execute:2800 milliseconds
After Sorted: [5, 8, 14, 17, 23, 27, 28, 30, 56, 68, 79, 91, 104, 107, 116, 137, 146, 149, 151, 165, 171, 176, 180, 180, 207, 231, 234, 253, 255, 257, 270, 276, 291, 293, 315, 345, 351, 374, 385, 391, 400, 409, 431, 437, 453, 481, 487, 490, 513, 525, 555, 563, 573, 575, 583, 593, 620, 639, 652, 656, 682, 686, 702, 710, 719, 721, 725, 735, 737, 744, 750, 763, 775, 812, 822, 823, 825, 837, 838, 841, 860, 886, 896, 916, 925, 940, 947, 972, 988, 999]

</pre>

Wow!! that is a huge difference. It is really quick for the sorted array
