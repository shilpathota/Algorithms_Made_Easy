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
**Initialize:** <br/>
left is the starting index of the array.<br>
right is the ending index of the array.<br>
**Loop:** Continue the loop while left is less than or equal to right.<br>
**Middle:** Calculate the middle index.<br>
**Check:** <br>
If the element at the middle index is the target, return the middle index.<br>
If the element at the middle index is less than the target, adjust left to middle + 1 to search in the right half.<br>
If the element at the middle index is greater than the target, adjust right to middle - 1 to search in the left half.<br>
**Not Found:** If the loop ends without finding the target, return -1.<br>

### What is the running time?
We know that linear search on an array of  \[ n \] elements might have to make as many as \[ n \] guesses. You probably already have an intuitive idea that binary search makes fewer guesses than linear search. You even might have perceived that the difference between the worst-case number of guesses for linear search and binary search becomes more striking as the array length increases. Let's see how to analyze the maximum number of guesses that binary search makes.<br/>



The key idea is that when binary search makes an incorrect guess, the portion of the array that contains reasonable guesses is reduced by at least half. If the reasonable portion had 32 elements, then an incorrect guess cuts it down to have at most 16. Binary search halves the size of the reasonable portion upon every incorrect guess.<br/>



If we start with an array of length 8, then incorrect guesses reduce the size of the reasonable portion to 4, then 2, and then 1. Once the reasonable portion contains just one element, no further guesses occur; the guess for the 1-element portion is either correct or incorrect, and we're done. So with an array of length 8, binary search needs at most four guesses.<br/>


What do you think would happen with an array of 16 elements? If you said that the first guess would eliminate at least 8 elements, so that at most 8 remain, you're getting the picture. So with 16 elements, we need at most five guesses.


By now, you're probably seeing the pattern. Every time we double the size of the array, we need at most one more guess. Suppose we need at most 
\[ m \] guesses for an array of length  \[ n \]. Then, for an array of length  \[ 2n \], the first guess cuts the reasonable portion of the array down to size  \[ n \], and at most  \[ m \] guesses finish up, giving us a total of at most  \[ m+1 \] guesses.



Let's look at the general case of an array of length  \[ n \]. We can express the number of guesses, in the worst case, as "the number of times we can repeatedly halve, starting at  \[ n \], until we get the value 1, plus one." But that's inconvenient to write out.<br/>
Fortunately, there's a mathematical function that means the same thing as the number of times we repeatedly halve, starting at  \[ n \], until we get the value 1: the base-2 logarithm of  \[ n \]. That's most often written as  \[ log_2 n\], but you may also see it written as \[ lg n\] 




### Condition to Satisfy
The array should be ordered which means it should be ascending or descending order for it to work
