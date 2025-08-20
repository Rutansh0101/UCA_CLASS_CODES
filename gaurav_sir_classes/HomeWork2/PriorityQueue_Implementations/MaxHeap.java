/**
 * A max heap implementation with dynamic resizing.
 */
class Heap {
  private int[] heap;
  private int capacity;
  private int size;

  /**
   * Constructs a Heap with the specified initial capacity.
   *
   * @param capacity the initial capacity of the heap
   */
  public Heap(int capacity) {
    this.heap = new int[capacity + 1];
    this.size = 0;
    this.capacity = capacity;
  }

  /**
   * Doubles the capacity of the heap array when it is full.
   */
  private void expandCapacity() {
    this.capacity *= 2;
    int[] newHeap = new int[this.capacity + 1];
    System.arraycopy(heap, 1, newHeap, 1, size);
    heap = newHeap;
  }

  /**
   * Reduces the capacity of the heap array when it is underutilized.
   */
  private void reduceCapacity() {
    this.capacity = Math.max(size, (capacity * 3) / 4);
    int[] newHeap = new int[this.capacity + 1];
    System.arraycopy(heap, 1, newHeap, 1, size);
    heap = newHeap;
  }

  /**
   * Checks if the heap is empty.
   *
   * @return true if the heap is empty; false otherwise
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns the current size of the heap.
   *
   * @return the number of elements in the heap
   */
  public int size() {
    return size;
  }

  /**
   * Inserts an element into the heap.
   *
   * @param element the element to insert
   */
  public void insert(int element) {
    if (size == capacity) {
      expandCapacity();
    }
    heap[++size] = element;
    swim(size);
  }

  /**
   * Moves the element at the specified index up to restore heap order.
   *
   * @param index the index of the element to swim
   */
  public void swim(int index) {
    while (index > 1 && heap[index] > heap[index / 2]) {
      swap(index, index / 2);
      index = index / 2;
    }
  }

  /**
   * Deletes and returns the maximum element (root) from the heap.
   *
   * @return the maximum element, or -1 if the heap is empty
   */
  public int deleteMin() {
    if (isEmpty()) {
      return -1;
    }
    int elementToBeDeleted = heap[1];
    swap(1, size--);
    sink(1);
    if (size > 0 && size < capacity / 4) {
      reduceCapacity();
    }
    return elementToBeDeleted;
  }

  /**
   * Moves the element at the specified index down to restore heap order.
   *
   * @param index the index of the element to sink
   */
  private void sink(int index) {
    while (2 * index <= size) {
      int j = 2 * index;
      if (j < size && heap[j] < heap[j + 1]) {
        j++;
      }
      if (heap[index] >= heap[j]) {
        break;
      }
      swap(index, j);
      index = j;
    }
  }

  /**
   * Swaps the elements at the two specified indices.
   *
   * @param i the first index
   * @param j the second index
   */
  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  /**
   * Prints the elements in the heap.
   */
  public void print() {
    for (int i = 1; i <= size; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }
}

/**
 * Demonstrates usage of the Heap class.
 */
public class MaxHeap {

  /**
   * Main method to run the heap example.
   *
   * @param args command line arguments (unused)
   */
  public static void main(String[] args) {
    Heap heap = new Heap(5);
    for (int i = 5; i >= 1; i--) {
      heap.insert(i * 5);
      heap.print();
    }
  }
}
