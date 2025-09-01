import java.util.*;

/**
 * LeetCode 295: Find Median from Data Stream
 * 
 * This class allows adding numbers to a data stream and finding the median of all numbers added so far.
 * It uses two priority queues (heaps) to efficiently find the median.
 * 
 * - A max-heap `left` stores the smaller half of the numbers.
 * - A min-heap `right` stores the larger half of the numbers.
 * 
 * This structure ensures that the median can be calculated in O(1) time from the top elements of the heaps.
 */
class MedianFinder {

    private PriorityQueue<Integer> left;  // Max-heap for the smaller half
    private PriorityQueue<Integer> right; // Min-heap for the larger half

    /**
     * Initializes the MedianFinder object.
     */
    public MedianFinder() {
        // `left` is a max-heap, so we use a reverse order comparator.
        left = new PriorityQueue<>(Collections.reverseOrder());
        // `right` is a min-heap by default.
        right = new PriorityQueue<>();
    }
    
    /**
     * Adds a number to the data structure.
     * The heaps are balanced after each addition to maintain the size difference at most 1.
     * @param num The number to add.
     */
    public void addNum(int num) {
        // Add to the appropriate heap
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        
        // Balance the heaps to ensure their sizes differ by at most 1
        if (left.size() - right.size() > 1) {
            // Left heap is too large
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            // Right heap is too large
            left.offer(right.poll());
        }
    }
    
    /**
     * Returns the median of all elements so far.
     * @return The median.
     */
    public double findMedian() {
        // This check handles the case where no elements have been added yet.
        if (left.isEmpty()) {
            return 0.0;
        }
        
        if (left.size() == right.size()) {
            // Even number of elements: median is the average of the two middle elements
            return (double) (left.peek() + right.peek()) / 2.0;
        }
        // Odd number of elements: median is the middle element (top of the left heap)
        return left.peek();
    }

    /**
     * Main method to demonstrate the MedianFinder functionality based on the LeetCode example.
     */
    public static void main(String[] args) {
        System.out.println("=== MedianFinder LeetCode Example Demonstration ===");
        
        MedianFinder medianFinder = new MedianFinder();
        System.out.println("MedianFinder medianFinder = new MedianFinder();");
        System.out.println("Output: null");
        System.out.println();

        medianFinder.addNum(1);
        System.out.println("medianFinder.addNum(1);    // arr = [1]");
        System.out.println("Output: null");
        System.out.println();
        
        medianFinder.addNum(2);
        System.out.println("medianFinder.addNum(2);    // arr = [1, 2]");
        System.out.println("Output: null");
        System.out.println();

        double median1 = medianFinder.findMedian();
        System.out.println("medianFinder.findMedian(); // returns " + median1);
        System.out.println("Output: " + median1);
        System.out.println();
        
        medianFinder.addNum(3);
        System.out.println("medianFinder.addNum(3);    // arr = [1, 2, 3]");
        System.out.println("Output: null");
        System.out.println();
        
        double median2 = medianFinder.findMedian();
        System.out.println("medianFinder.findMedian(); // returns " + median2);
        System.out.println("Output: " + median2);
        System.out.println();
    }
}

/**
 * How to use the MedianFinder class:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*
 * Follow-up Questions & Optimizations:
 *
 * 1. If all integer numbers from the stream are in the range [0, 100], how would you optimize?
 *    - We can use a simple integer array (or a hash map) of size 101 to act as a frequency map.
 *    - `int[] counts = new int[101];`
 *    - `addNum(num)` becomes `counts[num]++;`. This is an O(1) operation.
 *    - To find the median, we would iterate through the `counts` array to find the middle element(s).
 *      We'd keep a running total of numbers seen. When the total reaches the midpoint, we've found our median.
 *    - This approach is very fast for `addNum` and reasonably fast for `findMedian` if the range is small.
 *
 * 2. If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize?
 *    - This is a hybrid problem. We can use a combination of data structures.
 *    - Use the integer array `counts[101]` for numbers in the [0, 100] range.
 *    - For the other 1% of numbers (outliers), use two heaps (like the current solution) or two balanced binary search trees.
 *    - When `findMedian` is called, we need to consider elements from both the array and the heaps.
 *      We would first count the total number of elements in both structures to find the middle position.
 *      Then, we'd determine if the median falls within the [0, 100] range or in the outlier heaps.
 *      This requires a more complex `findMedian` logic but keeps `addNum` very fast for the common case.
 */