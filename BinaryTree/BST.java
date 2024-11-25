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
