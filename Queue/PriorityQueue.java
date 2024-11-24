package com.hackathon;

import java.util.ArrayList;

public class MyPriorityQueue {
    // initialization
    ArrayList<Integer> heap=null;

    //constructor
    public MyPriorityQueue(){
        heap = new ArrayList<Integer>();
    }

    //methods
    public int getMin(){
        if(heap.size()==0)
            throw new IllegalStateException("Priority Queue is empty");
        return heap.get(0);
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public int lChild(int index){
        return 2*index+1;
    }

    public int rChild(int index){
        return 2*index+2;
    }
    public int getSize(){
        return heap.size();
    }

    public int extractMin(){
        if(heap.size()==0)
            throw new IllegalStateException("Priority Queue is empty");
        int root = heap.get(0);
        int last = heap.remove(heap.size()-1);
        if(heap.size()!=0){
            heap.set(0,last);
            heapifyDown(0);
        }
        return root;
    }
    public void insert(int index){
        heap.add(index);
        heapifyUp(heap.size()-1);
    }

    public void heapifyDown(int i){

        int smallest = i;
        int lChild = lChild(i);
        int rChild = rChild(i);
        if(lChild < getSize() && heap.get(smallest) > heap.get(lChild)){
            smallest = lChild;
        }
        if(rChild < getSize() && heap.get(smallest) > heap.get(rChild)){
            smallest = rChild;
        }

        if(smallest !=i){
            swap(i,smallest);
            heapifyDown(smallest);
        }
    }
    public void heapifyUp(int i){
        while(i>0 && heap.get(parent(i))>heap.get(i)){
            swap(i,parent(i));
            i=parent(i);
        }
    }
    public void swap(int i,int j){
        int temp=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    public void printQueue() {
        System.out.println(heap);
    }
   public static void main(String[] args) {
        MyPriorityQueue pq = new MyPriorityQueue();

        // Insert elements into the priority queue
        pq.insert(20);
        pq.insert(15);
        pq.insert(10);
        pq.insert(5);
        pq.insert(30);

        System.out.println("Priority Queue after insertions:");
        pq.printQueue();

        // Peek at the smallest element
        System.out.println("Peek: " + pq.getMin());

        // Extract the smallest element
        System.out.println("Extract Min: " + pq.extractMin());

        System.out.println("Priority Queue after extraction:");
        pq.printQueue();

        // Insert another element
        pq.insert(8);

        System.out.println("Priority Queue after inserting 8:");
        pq.printQueue();
    }
}
