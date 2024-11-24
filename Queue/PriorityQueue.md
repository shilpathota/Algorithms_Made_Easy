# Priority Queue



### Key Operations
#### Insert Operation:

Add the new element at the end of the array.

Use heapifyUp to restore the min-heap property by comparing the new element with its parent and swapping them if necessary.
**Complexity:** O(logn) (height of the heap).
#### Extract Min Operation:

Remove the root element (minimum).

Replace the root with the last element in the heap.

Use heapifyDown to restore the min-heap property by comparing the root with its children and swapping if necessary.
**Complexity:** O(logn).
#### Get Min Operation:

Return the root element without removing it.
**Complexity:** O(1).
#### Heapify Up:

Move the newly added element up the tree until the min-heap property is satisfied.
**Complexity:** O(logn).
### Heapify Down:

Move the root element down the tree until the min-heap property is satisfied.
**Complexity:** O(logn).

### Optimizations of MinHeap

#### Dynamic Resizing
The ensureCapacity() method doubles the array size when the heap is full, ensuring efficient memory usage without crashes.

#### Iterative Heapify
Use iterative implementations of heapifyUp and heapifyDown to reduce stack usage and avoid recursive overhead.

#### Batch Heap Construction
Use the build-heap method to construct a heap from an unsorted array in O(n) time:
<pre>
  public void buildHeap(int[] array) {
    this.heap = array;
    this.size = array.length;

    for (int i = size / 2 - 1; i >= 0; i--) {
        heapifyDown(i);
    }
}
</pre>
#### Alternative Priority Queue
Java's PriorityQueue (part of java.util) can be used for MinHeap functionalities out of the box, reducing the need for custom implementations.

### Complexity Summary
<table>
<tr><th>Operation	</th><th>Time Complexity</th></tr>
<tr><td>Insert</td><td>O(logn)</td></tr>
<tr><td>Extract Min	</td><td>O(logn)</td></tr>
<tr><td>Get Min	</td><td>O(1)<td></tr>
<tr><td>Build Heap</td><td>O(n)</td></tr>
</table>

## Priority Queue Overview
A Priority Queue is a special type of queue where each element is associated with a priority, and elements are served based on their priority, not their insertion order. The element with the highest (or lowest, depending on the implementation) priority is dequeued first.

### Key Characteristics
- **Priority-Based Access:** Elements are processed based on their priority, not strictly in the order they were added.
- **Dynamic Nature:** The queue adjusts its ordering dynamically as elements are added or removed.
- **Two Types of Priority Queues:**
   - **Max Priority Queue:** The highest-priority element is dequeued first.
   - **Min Priority Queue:** The lowest-priority element is dequeued first.
- **Internally Implemented Using Heaps:** Most implementations use binary heaps for efficiency (MinHeap for Min Priority Queue, MaxHeap for Max Priority Queue).

<table border="1">
  <tr>
    <th>Operation</th>
    <th>Description</th>
    <th>Time Complexity</th>
  </tr>
  <tr>
    <td>Insert/Enqueue</td>
    <td>Adds an element based on priority.</td>
    <td>O(log n)</td>
  </tr>
  <tr>
    <td>Extract</td>
    <td>Removes and returns the highest/lowest priority.</td>
    <td>O(log n)</td>
  </tr>
  <tr>
    <td>Peek</td>
    <td>Retrieves the highest/lowest priority without removing it.</td>
    <td>O(1)</td>
  </tr>
  <tr>
    <td>Update Priority</td>
    <td>Changes the priority of an element.</td>
    <td>O(log n)</td>
  </tr>
  <tr>
    <td>Search</td>
    <td>Finds an element in the queue.</td>
    <td>O(n)</td>
  </tr>
</table>

# Difference Between Priority Queue and Queue

| **Feature**            | **Queue**                                                      | **Priority Queue**                                                                 |
|-------------------------|---------------------------------------------------------------|-----------------------------------------------------------------------------------|
| **Order of Processing** | Elements are processed in the order they were added (FIFO).    | Elements are processed based on their priority.                                   |
| **Priority**            | No notion of priority; insertion order matters.               | Elements have an associated priority; priority determines the order.              |
| **Internal Structure**  | Simple linear structure (e.g., list, array, linked list).      | Often implemented using a binary heap for efficiency.                             |
| **Insertion Complexity**| `O(1)` in most cases.                                         | `O(log n)` due to heap insertion or sorting.                                      |
| **Removal Complexity**  | `O(1)` for dequeue.                                           | `O(log n)` for extracting the highest or lowest priority.                         |
| **Peek Complexity**     | `O(1)`.                                                       | `O(1)`.                                                                           |
| **Use Case**            | Suitable for tasks requiring simple order processing.         | Suitable for tasks requiring prioritization (e.g., Dijkstra's algorithm).         |

## Priority Queue Implementations

### 1. Using Heaps (Binary Heap)
- This is the most common approach.
- Binary heaps provide efficient insertion and extraction operations.

### 2. Using Balanced Binary Search Trees (e.g., AVL or Red-Black Trees)
- Allows efficient priority updates and deletions.
- Slower insertion and extraction compared to heaps (`O(log n)`).

### 3. Unordered List
- **Insertion**: `O(1)`.
- **Extraction**: `O(n)` because you need to search for the element with the highest/lowest priority.

### 4. Ordered List
- **Insertion**: `O(n)`.
- **Extraction**: `O(1)` because the highest/lowest priority element is already at the start or end.

---

## Java PriorityQueue Implementation

### Default Implementation
Java provides a built-in `PriorityQueue` class in the `java.util` package, which is a **Min Priority Queue** by default.

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a Priority Queue (MinHeap by default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(15);

        // Display the top priority element (smallest element)
        System.out.println("Peek: " + minHeap.peek()); // Output: 5

        // Remove the top priority element
        System.out.println("Extract Min: " + minHeap.poll()); // Output: 5

        // Display remaining elements
        System.out.println("Remaining Elements: " + minHeap); // Output: [10, 15, 20]

        // Insert another element
        minHeap.add(2);

        // Display updated queue
        System.out.println("After Inserting 2: " + minHeap); // Output: [2, 15, 20, 10]
    }
}
```
## Applications of Priority Queue

1. **Dijkstra's Algorithm**  
   - Used to find the shortest path in a graph.

2. **Huffman Encoding**  
   - Used for data compression.

3. **Job Scheduling**  
   - Schedule tasks based on priority.

4. **Event Simulation**  
   - Process events based on their time or priority.

5. **Cache Eviction Policies**  
   - Implement **Least Recently Used (LRU)** or **Most Frequently Used (MFU)** policies.

## Optimizations for Priority Queue

1. **Binary Heap Optimizations**  
   - Use implicit heaps with arrays for better memory locality.  
   - Use Fibonacci Heaps for faster decrease-key operations (**O(1)**).

2. **Lazy Deletion**  
   - Instead of removing elements immediately, mark them as invalid and handle them lazily.

3. **Custom Priority Functions**  
   - Tailor priority comparisons for specific applications to improve efficiency.

4. **Hybrid Approaches**  
   - Use a combination of heaps and hash maps for faster element lookup.

## Custom Priority Queue
To use a custom comparator to implement a Max Priority Queue or prioritize custom objects, you can do the following:
```java
import java.util.*;

public class CustomPriorityQueueExample {
    public static void main(String[] args) {
        // Custom comparator for MaxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Insert elements
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(15);

        // Display the top priority element (largest element)
        System.out.println("Peek: " + maxHeap.peek()); // Output: 20

        // Remove the top priority element
        System.out.println("Extract Max: "
```

## Advantages and Disadvantages of Priority Queue

### Advantages
- Efficient insertions and deletions based on priority.
- Can handle dynamic priority changes efficiently.
- Flexible data structure with a variety of implementations.

### Disadvantages
- Not suitable for scenarios where random access is required.
- Searching for specific elements is inefficient.
- Extra overhead in maintaining the heap or tree structure.

## Java Implemetation of Priority Queue

```java
import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap; // Dynamic array to store heap elements

    // Constructor to initialize the priority queue
    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // Helper method to get the parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Helper method to get the left child index
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Helper method to get the right child index
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Insert a new element into the priority queue
    public void insert(int value) {
        heap.add(value);          // Add the new value to the end
        heapifyUp(heap.size() - 1); // Restore the min-heap property
    }

    // Extract and return the element with the highest priority (smallest element)
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int min = heap.get(0); // The root element (smallest element)
        int last = heap.remove(heap.size() - 1); // Remove the last element

        if (!heap.isEmpty()) {
            heap.set(0, last); // Move the last element to the root
            heapifyDown(0);    // Restore the min-heap property
        }

        return min;
    }

    // Peek at the highest priority element without removing it
    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap.get(0); // Return the root element
    }

    // Heapify up to maintain the min-heap property after insertion
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
            // Swap the current element with its parent
            swap(index, parent(index));
            index = parent(index); // Move up to the parent index
        }
    }

    // Heapify down to maintain the min-heap property after extraction
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Check if the left child is smaller than the current node
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        // Check if the right child is smaller than the current smallest
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        // If the smallest is not the current node, swap and continue heapifying
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display the elements of the priority queue
    public void printQueue() {
        System.out.println(heap);
    }

    // Main method to demonstrate Priority Queue usage
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        // Insert elements into the priority queue
        pq.insert(20);
        pq.insert(15);
        pq.insert(10);
        pq.insert(5);
        pq.insert(30);

        System.out.println("Priority Queue after insertions:");
        pq.printQueue();

        // Peek at the smallest element
        System.out.println("Peek: " + pq.peek());

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
```

## Explanation

### Data Structure
- The priority queue is implemented using an `ArrayList`, which dynamically resizes as elements are added or removed.
- The elements are organized in a **MinHeap**, ensuring the smallest element is always at the root.

### Key Methods
- **`insert(int value)`**:  
  Adds a new element to the priority queue and restores the min-heap property using `heapifyUp`.
- **`extractMin()`**:  
  Removes and returns the smallest element. The last element replaces the root, and `heapifyDown` is used to restore the min-heap property.
- **`peek()`**:  
  Returns the smallest element without removing it.
- **`heapifyUp(int index)`**:  
  Ensures the heap property is maintained by comparing the current element with its parent and swapping if necessary.
- **`heapifyDown(int index)`**:  
  Ensures the heap property is maintained by comparing the current element with its children and swapping if necessary.

### Time Complexity
- **Insertion**:  
  \( O(\log n) \), due to `heapifyUp`.
- **Extraction**:  
  \( O(\log n) \), due to `heapifyDown`.
- **Peek**:  
  \( O(1) \), as it simply returns the root.

### Example Output
```yaml
Priority Queue after insertions:
[5, 15, 10, 20, 30]

Peek:
5

Extract Min:
5

Priority Queue after extraction:
[10, 15, 30, 20]

Priority Queue after inserting 8:
[8, 10, 30, 20, 15]


