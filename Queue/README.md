# Queue
## What is a Queue?
A queue is a linear data structure that follows the First-In-First-Out (FIFO) principle. This means that the element that is inserted first will be the one to be removed first, just like a queue at a ticket counter or a line at a grocery store.

## Basic Operations in a Queue:
**Enqueue (Insert):** Add an element to the back (tail) of the queue.

**Dequeue (Remove):** Remove an element from the front (head) of the queue.

**Peek/Front:** Get the element at the front without removing it.

**isEmpty:** Check if the queue is empty.

**Size:** Get the number of elements in the queue.

## Types of Queues
### Simple Queue (Linear Queue):

Operates in a straightforward manner with enqueue and dequeue operations.

In a linear queue, once an element is dequeued, the space occupied by that element is wasted unless the elements are shifted or the queue is reset.
### Circular Queue:

This type of queue solves the problem of wasted space in a simple queue. When the last position of the queue is reached, the next element is inserted at the beginning (if there is space).

This is done by using modulo arithmetic for index calculation.
### Priority Queue:

In this type, elements are associated with priorities. The element with the highest priority is dequeued first, even if it wasn't enqueued first.

A priority queue can be implemented using a heap, and it operates like a regular queue but with priority ordering.
### Double-ended Queue (Deque):

This allows insertion and removal of elements from both ends (front and back). It can be classified into:
- **Input-restricted deque:** Only allows insertion at one end and removal from both ends.
- **Output-restricted deque:** Only allows removal at one end and insertion from both ends.

## Internal Implementation of a Queue
Queues can be implemented in two main ways:

### Array-based Queue (Static Queue):

A queue can be implemented using a fixed-size array. The index of the front and rear of the queue is tracked.

Problems with Array-based Queue: Once the elements are dequeued, space is wasted because the front pointer moves forward, but the array size remains fixed.
<pre>
public class Queue {
    private int[] queue;
    private int front, rear, size;
    private static final int CAPACITY = 10;

    public Queue() {
        queue = new int[CAPACITY];
        front = rear = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == CAPACITY;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        queue[rear] = item;
        rear = (rear + 1) % CAPACITY;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % CAPACITY;
        size--;
        return item;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }
}
</pre>
### Linked List-based Queue (Dynamic Queue):

A linked list allows dynamic allocation and resizing of the queue. The front and rear pointers are updated as elements are enqueued or dequeued.
<pre>
class QueueNode {
    int data;
    QueueNode next;
    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQueue {
    private QueueNode front, rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int item) {
        QueueNode newNode = new QueueNode(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }
}</pre>
## Time Complexity of Queue Operations
#### Enqueue (Insertion):

- Array-based Queue: O(1) if the queue is not full.
- Linked List-based Queue: O(1), as you simply add an element at the rear.
#### Dequeue (Deletion):

- **Array-based Queue:** O(1) if you're using a circular array. O(n) if you need to shift all elements in a linear array.
- **Linked List-based Queue:** O(1), as the front pointer simply moves to the next node.
#### Peek/Front:

Both Array-based and Linked List-based queues provide O(1) time complexity for peeking at the front of the queue.
#### isEmpty/Size:
- **Array-based:** O(1)
- **Linked List-based:** O(1)
## Optimizations for Queues
### Use a Circular Queue (Array-based) to Prevent Wasting Space:

Instead of shifting elements, a circular queue reuses the array space efficiently by wrapping around when the end of the array is reached.
### Use a Doubly Linked List for Deque Implementation:

If you need both enqueue and dequeue operations from both ends of the queue, use a doubly linked list which allows constant time insertion and removal from both the front and the back.
### Priority Queue for Specialized Use Cases:

If you need to process elements based on priority (instead of FIFO), use a priority queue (implemented using a heap). This ensures that you get the highest priority element in O(logn) time complexity.
### Use Linked List for Dynamic Queue Size:

A linked list-based queue has dynamic memory allocation, which is more memory-efficient than a fixed-size array-based queue, especially when the size of the queue is not predictable.
### Optimize Dequeue for Large Queues:

When using an array-based queue, instead of shifting elements after each dequeue, consider using a circular array or deque to avoid this costly operation.
### Batch Process with Multiple Enqueues/Dequeues:

If you have a scenario where multiple enqueue or dequeue operations can be batched, use batch processing or bulk enqueue/bulk dequeue** operations to reduce overhead in certain environments (e.g., I/O-heavy systems).
## Conclusion
Queues are simple yet powerful data structures used in various algorithms, such as BFS (Breadth-First Search), scheduling tasks, and handling asynchronous data.

The choice between array-based and linked list-based queues depends on the requirements for memory efficiency and the expected size of the queue.

Circular queues and deques offer optimizations over traditional queues to handle space and time complexity more efficiently.

## My Notes

![IMG_3122](https://github.com/user-attachments/assets/84a2b93c-dd34-42e7-bda8-7b281331961c)


## Priority Queues
 All about priority queue - [Priority Queues](https://github.com/shilpathota/Algorithms_Made_Easy/blob/main/Queue/PriorityQueue.md)

## Circular Queue
All about Circular Queuw - [Circular Queue](https://github.com/shilpathota/Algorithms_Made_Easy/blob/main/Queue/circularQueue.md)
