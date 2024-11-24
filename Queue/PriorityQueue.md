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
