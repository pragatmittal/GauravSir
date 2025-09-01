    import java.util.*;

public class largestRectangleInAHistogram {


    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];
        
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                leftsmall[i] = st.peek() + 1;
            } else {
                leftsmall[i] = 0;
            }
            st.push(i);
        }
        
        st.clear();
        
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                rightsmall[i] = st.peek() - 1;
            } else {
                rightsmall[i] = n - 1;
            }
            st.push(i);
        }
        
        int maxy = 0;
        for (int i = 0; i < n; ++i) {
            maxy = Math.max(maxy, heights[i] * (rightsmall[i] - leftsmall[i] + 1));
        }
        
        return maxy;
    }
    
    public static void main(String[] args) {
        largestRectangleInAHistogram solution = new largestRectangleInAHistogram();
        
        // Test case 1: [2,1,5,6,2,3]
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int result1 = solution.largestRectangleArea(heights1);
        System.out.println("Test 1 - Heights: [2,1,5,6,2,3]");
        System.out.println("Largest Rectangle Area: " + result1);
        System.out.println("Expected: 10\n");
        
        // Test case 2: [2,4]
        int[] heights2 = {2, 4};
        int result2 = solution.largestRectangleArea(heights2);
        System.out.println("Test 2 - Heights: [2,4]");
        System.out.println("Largest Rectangle Area: " + result2);
        System.out.println("Expected: 4\n");
        
        // Test case 3: [6,2,5,4,5,1,6]
        int[] heights3 = {6, 2, 5, 4, 5, 1, 6};
        int result3 = solution.largestRectangleArea(heights3);
        System.out.println("Test 3 - Heights: [6,2,5,4,5,1,6]");
        System.out.println("Largest Rectangle Area: " + result3);
        System.out.println("Expected: 12");
    }
}

