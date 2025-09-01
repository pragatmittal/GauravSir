import java.util.PriorityQueue;

/**
 * LeetCode 215: Kth Largest Element in an Array
 *
 * This class finds the kth largest element in an unsorted array.
 * It uses a min-heap (PriorityQueue) to keep track of the k largest elements seen so far.
 * This approach avoids sorting the entire array.
 */
public class KthLargestElement {

    /**
     * Finds the kth largest element using a min-heap of size k.
     * The time complexity is O(N log k), where N is the number of elements in the array.
     * The space complexity is O(k) to store the elements in the heap.
     *
     * @param nums The input array of numbers.
     * @param k    The kth largest element to find.
     * @return The kth largest element.
     */
    public int findKthLargest(int[] nums, int k) {
        // A min-heap will store the k largest elements.
        // The smallest of these k elements will be at the top (root) of the heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            // If the heap size exceeds k, we remove the smallest element (the root).
            // This ensures the heap always contains the k largest elements encountered so far.
            if (pq.size() > k) {
                pq.remove();
            }
        }
        // The root of the heap is the kth largest element.
        return pq.peek();
    }

    /**
     * Main method to demonstrate the findKthLargest functionality based on LeetCode examples.
     */
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        System.out.println("=== Kth Largest Element in an Array Demonstration ===");
        System.out.println("Note: This solution solves the problem without sorting the entire array.");
        System.out.println();

        // Example 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int result1 = solution.findKthLargest(nums1, k1);
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + result1); // Expected: 5
        System.out.println();

        // Example 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + result2); // Expected: 4
        System.out.println();
    }
}