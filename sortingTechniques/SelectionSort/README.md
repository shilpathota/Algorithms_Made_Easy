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

The Execution time is recoreded for random generated numbers between 1-1000 for 90 numbers as 
<pre>
  Before Sorted:[516, 851, 869, 867, 772, 480, 154, 180, 639, 147, 451, 724, 801, 214, 472, 829, 413, 683, 563, 419, 567, 266, 984, 334, 687, 704, 272, 478, 166, 952, 573, 659, 240, 569, 216, 54, 921, 563, 910, 808, 501, 398, 649, 501, 672, 66, 675, 875, 748, 261, 397, 293, 8, 548, 997, 143, 221, 610, 414, 885, 140, 910, 401, 516, 859, 699, 210, 917, 143, 929, 525, 458, 188, 492, 375, 502, 703, 846, 865, 197, 180, 790, 463, 60, 275, 172, 103, 719, 846, 151]
Time Taken to execute:64800 milliseconds
After Sorting: [8, 54, 60, 66, 103, 140, 143, 143, 147, 154, 166, 172, 180, 180, 188, 197, 210, 214, 216, 221, 240, 261, 266, 272, 275, 293, 334, 375, 397, 398, 401, 413, 414, 419, 451, 458, 463, 472, 478, 480, 492, 501, 501, 502, 516, 516, 525, 548, 563, 563, 567, 569, 573, 610, 639, 649, 659, 672, 675, 683, 687, 699, 703, 704, 719, 724, 748, 772, 790, 801, 808, 829, 846, 846, 851, 859, 865, 867, 869, 875, 885, 910, 910, 917, 921, 929, 952, 984, 997, 151]

</pre>
If we send the sorted array we get
<pre>
  Before Sorted:[78, 329, 127, 241, 309, 129, 926, 76, 229, 468, 275, 851, 690, 330, 490, 750, 197, 710, 110, 189, 16, 209, 546, 826, 437, 234, 56, 174, 903, 19, 979, 367, 616, 664, 567, 522, 625, 342, 545, 371, 488, 549, 696, 215, 99, 404, 611, 226, 908, 552, 244, 273, 997, 192, 266, 678, 962, 144, 740, 364, 949, 88, 145, 798, 613, 521, 349, 360, 328, 539, 894, 673, 591, 517, 677, 236, 233, 595, 679, 257, 255, 29, 507, 133, 375, 426, 662, 427, 68, 520]
Time Taken to execute:58700 milliseconds
After Sorting: [16, 19, 29, 56, 68, 76, 78, 88, 99, 110, 127, 129, 133, 144, 145, 174, 189, 192, 197, 209, 215, 226, 229, 233, 234, 236, 241, 244, 255, 257, 266, 273, 275, 309, 328, 329, 330, 342, 349, 360, 364, 367, 371, 375, 404, 426, 427, 437, 468, 488, 490, 507, 517, 520, 521, 522, 539, 545, 546, 549, 552, 567, 591, 595, 611, 613, 616, 625, 662, 664, 673, 677, 678, 679, 690, 696, 710, 740, 750, 798, 826, 851, 894, 903, 908, 926, 949, 962, 979, 997]

</pre>

I dont see a big difference as it already takes O(n^2) complexity

