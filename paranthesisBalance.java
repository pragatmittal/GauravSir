import java.util.*;
public class paranthesisBalance {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    st.push(c);
                } else {
                    if (st.isEmpty()) return false;
                    char p = st.pop();
                    if ((c == ')' && p == '(') || (c == ']' && p == '[') || (c == '}' && p == '{')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            return st.isEmpty();
        }
    }
    
    public static void main(String[] args) {
        paranthesisBalance pb = new paranthesisBalance();
        Solution solution = pb.new Solution();
        
        String test1 = "()";
        boolean result1 = solution.isValid(test1);
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Is Valid: " + result1);
        System.out.println("Expected: true\n");
        
        String test2 = "()[]{}" ;
        boolean result2 = solution.isValid(test2);
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Is Valid: " + result2);
        System.out.println("Expected: true\n");
        
        String test3 = "(]";
        boolean result3 = solution.isValid(test3);
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Is Valid: " + result3);
        System.out.println("Expected: false\n");
        
        String test4 = "([)]";
        boolean result4 = solution.isValid(test4);
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Is Valid: " + result4);
        System.out.println("Expected: false\n");
        
        String test5 = "{[()]}";
        boolean result5 = solution.isValid(test5);
        System.out.println("Test 5: \"" + test5 + "\"");
        System.out.println("Is Valid: " + result5);
        System.out.println("Expected: true\n");
        
        String test6 = "";
        boolean result6 = solution.isValid(test6);
        System.out.println("Test 6: \"" + test6 + "\" (empty string)");
        System.out.println("Is Valid: " + result6);
        System.out.println("Expected: true");
    }
}