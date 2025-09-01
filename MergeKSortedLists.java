
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 23: Merge k Sorted Lists
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * This solution uses a divide and conquer approach.
 */
public class MergeKSortedLists {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Contains the logic to merge the lists.
     */
    static class Solution {
        
        /**
         * Merges two sorted linked lists recursively.
         * @param l1 The first sorted list.
         * @param l2 The second sorted list.
         * @return The head of the merged sorted list.
         */
        public ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            } else {
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }

        /**
         * The main function that initiates the merging process.
         * @param lists An array of sorted linked lists.
         * @return The head of the single merged sorted list.
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null; // Handle edge cases: null or empty array
            }
            return mergeRange(lists, 0, lists.length - 1);
        }

        /**
         * A helper function that recursively divides the array of lists and merges them.
         * This is the core of the divide and conquer strategy.
         * @param lists The array of lists.
         * @param start The starting index of the range to merge.
         * @param end The ending index of the range to merge.
         * @return The head of the merged list for the given range.
         */
        private ListNode mergeRange(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start]; // Base case: only one list in the range
            }
            if (start + 1 == end) {
                return merge(lists[start], lists[end]); // Base case: two lists in the range
            }
            
            int mid = start + (end - start) / 2;
            ListNode left = mergeRange(lists, start, mid);
            ListNode right = mergeRange(lists, mid + 1, end);
            return merge(left, right);
        }
    }

    /**
     * Main method to demonstrate the mergeKLists functionality.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("=== Merge k Sorted Lists Demonstration ===");

        // Example 1
        System.out.println("Example 1:");
        ListNode[] lists1 = new ListNode[]{
            createList(new int[]{1, 4, 5}),
            createList(new int[]{1, 3, 4}),
            createList(new int[]{2, 6})
        };
        System.out.println("Input: [[1,4,5],[1,3,4],[2,6]]");
        ListNode result1 = solution.mergeKLists(lists1);
        System.out.print("Output: ");
        printList(result1); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
        System.out.println();

        // Example 2
        System.out.println("Example 2:");
        ListNode[] lists2 = new ListNode[]{};
        System.out.println("Input: []");
        ListNode result2 = solution.mergeKLists(lists2);
        System.out.print("Output: ");
        printList(result2); // Expected: (empty)
        System.out.println();

        // Example 3
        System.out.println("Example 3:");
        ListNode[] lists3 = new ListNode[]{
            createList(new int[]{})
        };
        System.out.println("Input: [[]]");
        ListNode result3 = solution.mergeKLists(lists3);
        System.out.print("Output: ");
        printList(result3); // Expected: (empty)
        System.out.println();
    }

    // Helper function to create a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}