## Circular Queue

A **Circular Queue** is a type of queue data structure in which the last position is connected back to the first position to make a circular arrangement. This allows the queue to efficiently utilize space, especially in cases where elements are frequently enqueued and dequeued. It overcomes the limitation of a normal queue, which may waste space if elements are dequeued and space is left unused.

### Key Characteristics of Circular Queue:
- **Fixed Size:** It has a predefined size, like a regular queue.
- **Circular Structure:** The rear of the queue wraps around to the front when the end is reached.
- **Efficient Use of Space:** No space is wasted, unlike the regular queue which may leave unused spaces when elements are dequeued.

### Operations:
1. **Enqueue:** Insert an element at the rear of the queue.
2. **Dequeue:** Remove an element from the front of the queue.
3. **Peek/Front:** Retrieve the front element without removing it.
4. **IsFull:** Check if the queue is full.
5. **IsEmpty:** Check if the queue is empty.
6. **Size:** Returns the current number of elements in the queue.

### Circular Queue Structure:
- **Front:** Points to the first element.
- **Rear:** Points to the last element.
- **Size:** The total number of elements in the queue.

The positions of `front` and `rear` are managed using modular arithmetic to handle wrapping around.

### Implementation of Circular Queue in Java

```java
public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue with a given capacity
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = this.size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            queue[rear] = value;
            rear = (rear + 1) % capacity;  // Circular increment
            size++;
        }
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Indicating empty queue
        } else {
            int value = queue[front];
            front = (front + 1) % capacity;  // Circular increment
            size--;
            return value;
        }
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the current size of the queue
    public int getSize() {
        return size;
    }

    // Print the current elements in the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);  // Queue with capacity 5

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.printQueue();  // Expected output: Queue: 10 20 30 40 50

        System.out.println("Dequeue: " + cq.dequeue());  // Expected output: 10
        System.out.println("Peek: " + cq.peek());  // Expected output: 20

        cq.enqueue(60);  // Adding an element after a dequeue
        cq.printQueue();  // Expected output: Queue: 20 30 40 50 60
    }
}
```
### Key Methods:
1. **enqueue(int value):**
   - Adds an element to the queue at the rear.
   - If the queue is full, the operation fails.
   - Uses modular arithmetic to wrap around when reaching the end of the array.

2. **dequeue():**
   - Removes the element at the front of the queue.
   - Uses modular arithmetic to wrap around when the front reaches the end.

3. **peek():**
   - Returns the front element without removing it.

4. **isFull():**
   - Checks if the queue is full.

5. **isEmpty():**
   - Checks if the queue is empty.

6. **getSize():**
   - Returns the current size of the queue.

### Time Complexity:
- **Enqueue:** \( O(1) \) – Insertion at the rear.
- **Dequeue:** \( O(1) \) – Removal from the front.
- **Peek:** \( O(1) \) – Fetch the front element without removal.
- **isFull:** \( O(1) \) – Check if the queue is full.
- **isEmpty:** \( O(1) \) – Check if the queue is empty.

### Advantages:
- **Efficient Space Utilization:** Since the last element is connected back to the first, it helps in utilizing space efficiently.
- **Constant Time Operations:** All operations (enqueue, dequeue, peek) are performed in constant time.

### Disadvantages:
- **Fixed Size:** The capacity of a circular queue is fixed, and once it's full, no more elements can be inserted unless space is freed up by dequeuing elements.
- **Complexity in Resizing:** Unlike dynamic queues, resizing a circular queue is not straightforward.

### Use Cases:
- **Buffer Management:** Used in applications like data streaming, where you need to manage a fixed-size buffer.
- **Round-Robin Scheduling:** Used in operating systems for process scheduling (assigning time slices).
- **Queue Management in Circular Buffers:** Handling continuous streams of data, such as network packets or IO buffers.
