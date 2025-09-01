public class LongestValidParentheses {
    
    public int longestValidParentheses(String s) {
        
        int left = 0;
        int right = 0;
        int max = 0;

        // Left to right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        // Right to left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (right < left) {
                left = 0;
                right = 0;
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        
        // Test case 1: "(()"
        String test1 = "(()";
        int result1 = solution.longestValidParentheses(test1);
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Longest Valid Parentheses: " + result1);
        System.out.println("Expected: 2\n");
        
        // Test case 2: ")()())"
        String test2 = ")()())";
        int result2 = solution.longestValidParentheses(test2);
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Longest Valid Parentheses: " + result2);
        System.out.println("Expected: 4\n");
        
        // Test case 3: ""
        String test3 = "";
        int result3 = solution.longestValidParentheses(test3);
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Longest Valid Parentheses: " + result3);
        System.out.println("Expected: 0\n");
        
        // Test case 4: "()(()"
        String test4 = "()(()";
        int result4 = solution.longestValidParentheses(test4);
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Longest Valid Parentheses: " + result4);
        System.out.println("Expected: 2\n");
        
        // Test case 5: "(()())"
        String test5 = "(()())";
        int result5 = solution.longestValidParentheses(test5);
        System.out.println("Test 5: \"" + test5 + "\"");
        System.out.println("Longest Valid Parentheses: " + result5);
        System.out.println("Expected: 6");
    }
}
