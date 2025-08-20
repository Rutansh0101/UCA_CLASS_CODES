import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * A class to find the kth largest element in an array.
 */
public class KthLargestElement {

  /**
   * Finds the kth largest element in the given array.
   *
   * @param nums the input array of integers
   * @param k    the kth position to find the largest element for
   * @return the kth largest element in the array
   */
  public static int findKthLargest(final int[] nums, final int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    for (int num : nums) {
      pq.add(num);
    }

    for (int i = 1; i < k; i++) {
      pq.poll();
    }

    return pq.poll();
  }

  /**
   * Main method to read input and print the kth largest element.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.print("Enter the value of k: ");
    int k = sc.nextInt();

    System.out.println(findKthLargest(arr, k));
  }
}
