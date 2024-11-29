# Dynamic Programming

Dynamic programming (DP) is a technique used to solve problems by breaking them down into overlapping subproblems, solving each subproblem once, and storing the results for future reference. A general template for solving DP problems includes the following steps:

## Template for Dynamic Programming Problems
### Identify the Problem Type:

Determine if the problem has overlapping subproblems and optimal substructure.
**Common problem types:** sequence alignment, pathfinding, partitioning, etc.
### Define the State:

Define a DP state (`dp[i][j]`, `dp[i]`, etc.) that represents a subproblem.
The state should capture enough information to uniquely represent a solution to the subproblem.
### Define the Recurrence Relation:

Derive the relation that allows you to compute `dp[i]` (or `dp[i][j]`) in terms of smaller subproblems.
### Base Case(s):

Identify trivial cases where the solution is known (e.g., `dp[0]`, `dp[1]`).
### State Transition:

Write the logic for computing the DP states using the recurrence relation.
### Iterative or Recursive Implementation:

Use a bottom-up (iterative) or top-down (recursive with memoization) approach.
### Retrieve the Final Answer:

Typically, this is the value of `dp[n]`, `dp[n][m]`, or another relevant state.


let us apply this template to any problems to solve it.

## Fibonacci Numbers
### Problem
Comput ethe n-th Fibonacci Number
### Solution
#### 1. Defining State
   Let dp[i] represent the ith fibonacci number
#### 2. Recurrence Relation
  dp[i] = dp[i-1] + dp[i-2]
#### 3. Base Case
  dp[0] = dp[1] = 1
#### 4. Final Answer
  dp[n]
```java
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci number " + n + " is " + fibonacci(n));
    }
}
```
