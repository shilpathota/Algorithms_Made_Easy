# Binary Search Algorithm

### What is Binary Search?
It is a searching technique where you divide the list into 2 halfs and search the desired number in one half and if not found search other half. This process is repeated and make the list smaller and smaller while you search for desired number.
This way the best solution might be you find the desired value in the first half and searching the other half can be skipped.

### Example
Imagine you have a big box of toy cars, and they're all lined up in a row from smallest to biggest. Let's say you want to find a special red car.

Instead of looking at each car one by one, here's a faster way to find it:

Start in the middle: Look at the car that's right in the middle of the line.
Compare: If the middle car is the red car, hooray! You found it.
Go left or right: If the middle car is not the red car, decide if the red car should be to the left (smaller) or to the right (bigger) of the middle car.
Repeat: Now, take the half where you think the red car is and find the middle of that half. Repeat the steps until you find the red car.
So, each time, you're making your search area smaller and smaller until you find your special red car. This is what we call a binary search!

### Pictorial Explanation
![image](https://github.com/shilpathota/Algorithms_Made_Easy/assets/36531617/54ba05f5-1d8a-465e-8d5f-b9570c271dea)

### Pseudo Code
<pre>
  function binarySearch(array, target):
    left ← 0
    right ← length of array - 1

    while left ≤ right:
        middle ← floor((left + right) / 2)

        if array[middle] = target:
            return middle
        else if array[middle] < target:
            left ← middle + 1
        else:
            right ← middle - 1

    return -1  // target not found in array

</pre>
<b>Explanation:</b><br>
Initialize:<br>
left is the starting index of the array.<br>
right is the ending index of the array.<br>
Loop: Continue the loop while left is less than or equal to right.<br>
Middle: Calculate the middle index.<br>
Check:<br>
If the element at the middle index is the target, return the middle index.<br>
If the element at the middle index is less than the target, adjust left to middle + 1 to search in the right half.<br>
If the element at the middle index is greater than the target, adjust right to middle - 1 to search in the left half.<br>
Not Found: If the loop ends without finding the target, return -1.<br>
