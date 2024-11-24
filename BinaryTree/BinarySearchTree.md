# Binary Search Tree

## Binary Search Tree (BST) and Its Implementation

### What is a Binary Search Tree (BST)?
A **Binary Search Tree (BST)** is a type of binary tree where each node has at most two children, referred to as the **left** and **right** children. The BST has the following properties:
- **Left child**: The value of the left child is less than its parent's value.
- **Right child**: The value of the right child is greater than its parent's value.
- This property ensures that for any node, the left subtree contains only nodes with values less than the node’s value, and the right subtree contains only nodes with values greater than the node’s value.

### Advantages of a BST:
- **Efficient searching**: Searching in a balanced BST has a time complexity of \( O(\log n) \), making it faster than linear search in unsorted lists.
- **Efficient insertion and deletion**: Both insertion and deletion operations are efficient and can also run in \( O(\log n) \) time in the average case, assuming the tree is balanced.

### Disadvantages of a BST:
- **Unbalanced tree**: If the tree becomes unbalanced (e.g., if data is inserted in sorted order), the time complexity of search, insert, and delete operations can degrade to \( O(n) \).
  
### Operations on a Binary Search Tree:
1. **Insertion**: Insert a new node in the correct position while maintaining the BST property.
2. **Deletion**: Remove a node, ensuring that the BST property is still maintained.
3. **Searching**: Search for a node with a given value.
4. **Traversal**: Traverse the tree in different ways such as In-order, Pre-order, Post-order.

### Types of Traversals:
1. **In-order traversal**: Visit left child, then current node, then right child. This results in nodes being visited in ascending order.
2. **Pre-order traversal**: Visit current node, then left child, then right child.
3. **Post-order traversal**: Visit left child, then right child, then current node.

---

### Binary Search Tree Implementation in Java:

```java
class BinarySearchTree {
    // Node class to define structure of each node
    class Node {
        int data;
        Node left, right;

        // Constructor to create a new node
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Root node of BST
    Node root;

    // Constructor for the BST
    public BinarySearchTree() {
        root = null;
    }

    // Insert a node in the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive function to insert a new node
    private Node insertRec(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data)
            root.left = insertRec(root.left, data); // Insert in left subtree
        else if (data > root.data)
            root.right = insertRec(root.right, data); // Insert in right subtree

        // Return the (unchanged) node pointer
        return root;
    }

    // Search for a node with a given value
    public boolean search(int data) {
        return searchRec(root, data);
    }

    // Recursive function to search for a node
    private boolean searchRec(Node root, int data) {
        // Base case: root is null or data is present at the root
        if (root == null)
            return false;
        if (root.data == data)
            return true;

        // Data is greater than root's data, search in right subtree
        if (data > root.data)
            return searchRec(root.right, data);

        // Data is smaller than root's data, search in left subtree
        return searchRec(root.left, data);
    }

    // Delete a node
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Recursive function to delete a node
    private Node deleteRec(Node root, int data) {
        // Base case: root is null
        if (root == null)
            return root;

        // Otherwise, recur down the tree
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Get the inorder successor (smallest node in the right subtree)
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal of the tree
    public void inorder() {
        inorderRec(root);
    }

    // Recursive function to perform in-order traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the binary search tree
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inorder(); // Output: 20 30 40 50 60 70 80

        System.out.println("\n\nSearch for 40: " + tree.search(40)); // Output: true
        System.out.println("Search for 90: " + tree.search(90)); // Output: false

        System.out.println("\nDelete 20:");
        tree.delete(20);
        tree.inorder(); // Output: 30 40 50 60 70 80
    }
}
```
## Explanation of Key Methods:

1. **insert(int data)**:
   - This method inserts a new node with the given value into the BST by calling a recursive helper method `insertRec`.

2. **search(int data)**:
   - This method checks if a given value exists in the BST by calling a recursive helper method `searchRec`.

3. **delete(int data)**:
   - This method deletes a node with the given value by calling a recursive helper method `deleteRec`. If the node has two children, it finds the inorder successor, replaces the node, and deletes the successor.

4. **inorder()**:
   - This method prints the values in the tree in ascending order by calling the `inorderRec` method, which recursively traverses the tree.

---

## Time Complexity:

- **Insertion**:  
  \( O(\log n) \), in the average case, assuming the tree is balanced. In the worst case (unbalanced tree), it can degrade to \( O(n) \).

- **Search**:  
  \( O(\log n) \), in the average case, assuming the tree is balanced. In the worst case, it can degrade to \( O(n) \).

- **Deletion**:  
  \( O(\log n) \), in the average case, assuming the tree is balanced. In the worst case, it can degrade to \( O(n) \).

---

## Example Output:

```yaml
In-order traversal:
20 30 40 50 60 70 80

Search for 40: true
Search for 90: false

Delete 20:
30 40 50 60 70 80
```
## Summary:

- A **Binary Search Tree (BST)** allows efficient searching, insertion, and deletion of elements, assuming it is balanced.
- The provided implementation includes methods for inserting, searching, deleting, and traversing the tree.
- The time complexity for these operations is:
  - \( O(log n) \) in the best and average cases, assuming the tree is balanced.
  - However, it can degrade to \( O(n) \) in the worst case when the tree is unbalanced.
