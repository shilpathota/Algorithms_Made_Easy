# Two Pointer

The name two pointers does justice in this case, as it is exactly as it sounds. It's the use of two different pointers (usually to keep track of array or string indices) to solve a problem involving said indices with the benefit of saving time and space

But what are pointers? In computer science, a pointer is a reference to an object. In many programming languages, that object stores a memory address of another value located in computer memory, or in some cases, that of memory-mapped computer hardware.

In many problems involving collections such as arrays or lists, we have to analyze each element of the collection compared to its other elements.

There are many approaches to solving problems like these. For example we usually start from the first index and iterate through the data structure one or more times depending on how we implement our code.

Sometimes we may even have to create an additional data structure depending on the problem's requirements. This approach might give us the correct result, but it likely won't give us the most space and time efficient result.

This is why the two-pointer technique is efficient. We are able to process two elements per loop instead of just one. Common patterns in the two-pointer approach entail:

- Two pointers, each starting from the beginning and the end until they both meet.
- One pointer moving at a slow pace, while the other pointer moves at twice the speed.
  
These patterns can be used for string or array questions. They can also be streamlined and made more efficient by iterating through two parts of an object simultaneously. You can see this in the Two Sum problem or Reverse a String problems.

You're tasked with figuring out the pair of elements where arr[p] + arr[q] add up to a certain number. (To try this problem out, check the Two Sum and Sorted Two Sum problems here.)

The brute force solution is to compare each element with every other number, but that's a time complexity of O(n^2). We can do better!

So let's optimize. You need to identify the indices pointer_one and pointer_two whose values sum to the integer target.

Let's initialize two variables, pointer_one and pointer_two, and consider them as our two pointers.

<pre>
import java.util.Arrays;

public class Main {
    private static int[] twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if (arr[left] + arr[right] == target) {
                return new int[] {arr[left], arr[right]};
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[] { 1, 3, 4, 8, 9 }, 11);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
</pre>

Since the array is already sorted, and we're looking to process an index at each iteration, we can use two pointers to process them faster. One pointer starts from the beginning of the array, and the other pointer begins from the end of the array, and then we add the values at these pointers.

Once we're set up, what we want to do is check if the current pointers already sum up to our target. This might happen if the correct ones are on the exact opposite ends of the array.

These snippets implement the logic to check if the sum of two numbers from an array equals the target value, returning the appropriate result. In Python, the code snippet returns a boolean value, while the other languages return the indices or values of the two numbers that add up to the target.

However, it likely will not be the target immediately. Thus, we apply this logic: if the sum of the values is less than the target value, we increment the left pointer (move your left pointer pointer_one one index rightwards).

And if the sum is higher than the target value, we decrement the right pointer (correct the position of your pointer pointer_two if necessary).

In other words, understand that if arr[pointer_one] < target-arr[pointer_two], it means we should move forward on pointer_one to get closer to where we want to be in magnitude.



