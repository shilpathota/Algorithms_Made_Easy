# Mancher's algorithm
![image](https://github.com/user-attachments/assets/20a3b293-6461-4f8c-80b9-31392cc393a2)

Let us see an example
![image](https://github.com/user-attachments/assets/d13d5452-e138-4315-8de5-1249da4d2726)

We havent explored anything yet so we go with the 4th rule  and mark the array as 1.

![image](https://github.com/user-attachments/assets/4c4a6912-f329-4ef0-a450-8fcc83a4d4c0)

If you look at the a, we are still in 4th and we explore the neighbours and the count is 3


![image](https://github.com/user-attachments/assets/06134be0-1f8c-4d26-a84c-0ffb3026b280)

Consider the letter i, we are still in situation where the mirror which is i is within the larger palindrome centered around and so we explore beyond the mirror length which is 1 and conclude that the value would be 3 as i and d are not matching

![image](https://github.com/user-attachments/assets/3f7c3e58-8a68-4af1-8227-17ff4da37f5a)

Consider the letter a, we have the mirror as a but the a is outside the larger palindrome which is aia that is iai. So 3rd point applies.We explore beyond the larger palindrome.but i and d are not equal which are neighbours, we get a value as 1.

![image](https://github.com/user-attachments/assets/8a051ed7-e9b1-4ef3-b338-13adb5831a2e)

At this d, we realize the largest palindrome is ended already so no mirror image. so compare the neighbours and the value is 7 which is aia on either side

![image](https://github.com/user-attachments/assets/3bc24458-8c76-4c51-a5f6-b7478cbd3306)

For letter a it has mirror image whcih is within the largest palindrome centered around d and can copy the mirror length as per rule 1

![image](https://github.com/user-attachments/assets/7a018b31-5fde-4be0-a9c5-babce21df008)

Now for the letter i the mirror image i has the length that is till the border of larger palindrome so the mirror length cannot be copied and can extend beyond the mirror length 3. Here ada on either side so the value would be 7

![image](https://github.com/user-attachments/assets/b826d8d2-cb86-477f-bf81-29eff475f2fe)

For this we are in situation 1 where a is contained in the larger palindrome centered around i.So mirror length can be copied

![image](https://github.com/user-attachments/assets/912ba2f8-dad5-4e1c-9626-2402dc43fac0)

For d the mirror d is outside the border and beyond and record the length as 3

![image](https://github.com/user-attachments/assets/4de15c07-a525-4ebb-936e-97344290798f)

For a we are in situation 2 and so the where a is at the border and can extend beyond but d and k does not match so value is 1

![image](https://github.com/user-attachments/assets/04586def-0b0a-4223-9388-d2a6791ed9e6)

K is situation 4 where it is not in larger palindrom and its value is 1

The largest palindrome is 7

this is applicable for odd lengths, for even length, we can insert dummy characters where the length would become 2*n +1 which is always odd then the palindrome length is halved from the modified string.


Runtime is O(n)

## Algorithm

### Key Concepts of Manacher's Algorithm
#### Modified String:
The input string is modified to handle even-length palindromes. For example, "abababa" is transformed into "#a#b#a#b#a#b#a#" by adding a # between every character and at the start and end. This ensures all palindromes are of odd length in the modified string.

#### Variables Used:

C: Center of the current palindrome.
R: Right boundary of the current palindrome.
L[i]: Length of the palindrome centered at position i in the modified string.
iMirror: The mirror position of i with respect to C.
#### Purpose of LPS Array (L):
L[i] stores the radius of the palindrome centered at position i. From this, we can determine the longest palindromic substring.

#### Step-by-Step Execution
Input: "abababa"

Modified String: "#a#b#a#b#a#b#a#"

#### Initialization:
C = 0 (Initial center is the first character).

R = 0 (No palindrome boundary initially).

L = [0, 0, 0, 0, ..., 0] (Initialize all palindrome radii to 0).

Iterating through the modified string:

Index 1 (i = 1):

iMirror = 2 * C - i = -1 (No valid mirror position).

Expand the palindrome at i = 1: #a# is a palindrome.

Update L[1] = 1.

Update C = 1 and R = 2 (right boundary expands to 2).

Index 2 (i = 2):

iMirror = 2 * C - i = 0.

No expansion: L[2] = 0.

No changes to C or R.

Index 3 (i = 3):

iMirror = 2 * C - i = 1.

Expand the palindrome at i = 3: #a#b#a# is a palindrome.

Update L[3] = 3.

Update C = 3 and R = 6.

Index 4 (i = 4):

iMirror = 2 * C - i = 2.

Expand: L[4] = 4.

Update C = 4 and R = 8.

Index 5 (i = 5):

iMirror = 3.

Expand: L[5] = 5.

Update C = 5 and R = 10.

Continue similar steps for all positions...

#### Result Extraction:
The maximum value in L is 7 at index 7 (center position in the modified string).

Convert this back to the original string by identifying the start and end indices.

Longest Palindromic Substring = "abababa"

#### Why This Algorithm is Efficient
Instead of comparing substrings repeatedly (as in brute-force methods), Manacher's Algorithm cleverly uses symmetry (mirrored palindromes) and boundaries (R) to minimize redundant calculations.
Time Complexity: 𝑂(𝑁), where  𝑁 is the length of the modified string.




