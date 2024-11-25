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
package com.hackathon;


public class BST{
    Node root;
    public BST(){
        root = null;
    }
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left=this.right=null;
        }
    }
    //insert
    public void insert(int data){
        root = insertRec(root, data);
    }
    //insertRec
    public Node insertRec(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data)
            root.left = insertRec(root.left,data);
        if(data > root.data)
            root.right = insertRec(root.right,data);
        return root;
    }
    //search
    public Boolean search(int data){
        if(root == null) return false;
        return searchRec(root,data);
    }
    //searchRec
    public Boolean searchRec(Node root,int data){
        if(root.data == data) return true;
        if(root.data > data)  return searchRec(root.left,data);
        return searchRec(root.right,data);

    }

    //remove
    public void remove(int data){
        if(search(data)){
            root = removeRec(root,data);
        }
    }
    //removeRec
    public Node removeRec(Node root, int data){
        if(root == null) return root;
        if(root.data < data)
            root.right = removeRec(root.right,data);
        else if ( root.data>data){
            root.left = removeRec(root.left, data);
        }
        else{
            if(root.left ==null && root.right ==null){
                root = null;
            }
            else if( root.right != null){//find successor
                root.data = successor(root);
                root.right = removeRec(root.right,root.data);
            }
            else{//find predecessor
                root.data = predecessor(root);
                root.left = removeRec(root.left , root.data);
            }
        }
        return root;
    }
    public int successor(Node root){
        root = root.right;
        while(root.left!=null){
            root=root.left;
        }
        return root.data;
    }
    public int predecessor(Node root){
        root = root.left;
        while(root.right!=null){
            root=root.right;
        }
        return root.data;
    }
    //display
    public void display(){
        if(root == null) return;
        displayRec(root);
    }
    //displayRec
    public void displayRec(Node root){
        if(root == null) return;
        displayRec(root.left);
        System.out.print(root.data + " ");
        displayRec(root.right);
    }
    public static void main(String[] args) {
        BST pq = new BST();

        // Insert elements into the priority queue
        pq.insert(20);
        pq.insert(15);
        pq.insert(10);
        pq.insert(5);
        pq.insert(30);

        System.out.println("Priority Queue after insertions:");
        pq.display();

        // Insert another element
        pq.remove(10);

        System.out.println("Priority Queue after removing 10:");
        pq.display();
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
