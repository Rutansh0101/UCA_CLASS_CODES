class Heap {
  int[] heap;
  int capacity;
  int size;

  public Heap(int capacity) {
    this.heap = new int[capacity + 1];
    this.size = 0;
    this.capacity = capacity;
  }

  private void expandCapacity() {
    this.capacity *= 2;
    int[] newHeap = new int[this.capacity + 1];
    for (int i = 1; i <= size; i++) {
      newHeap[i] = heap[i];
    }
    heap = newHeap;
    return;
  }

  private void reduceCapacity() {
    this.capacity = Math.max(size, (capacity * 3) / 4);
    int[] newHeap = new int[this.capacity + 1];
    for (int i = 1; i <= size; i++) {
      newHeap[i] = heap[i];
    }
    heap = newHeap;
    return;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return size;
  }

  public void insert(int element) {
    if (size == capacity) {
      expandCapacity();
    }
    this.heap[++size] = element;
    swim(size);
  }

  public void swim(int index) {
    while (index > 1 && (heap[index] < heap[index / 2])) {
      swap(index, index / 2);
      index = index / 2;
    }
    return;
  }

  public int deleteMin() {
    if (isEmpty()) return -1;
    int elementToBeDeleted = heap[1];
    swap(1, size--);
    sink(1);
    if (size > 0 && size < capacity / 4) {
      reduceCapacity();
    }
    return elementToBeDeleted;
  }

  private void sink(int index) {
    while (2 * index <= size) {
      int j = 2 * index;
      if (j < size && heap[j] > heap[j + 1]) {
        j++;
      }

      if (heap[index] <= heap[j]) {
        break;
      }

      swap(index, j);
      index = j;
    }
    return;
  }

  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
    return;
  }

  public void print() {
    for (int i = 1; i <= size; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
    return;
  }
}

public class MinHeap {

  public static void main(String[] args) {
    Heap heap = new Heap(5);
    for (int i = 5; i >= 1; i--) {
      heap.insert(i * 5);
      heap.print();
    }
    return;
  }
}
