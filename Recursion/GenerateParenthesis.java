package Recursion;
import java.util.*;

public class GenerateParenthesis {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * 
     * Constraints:
     * 1. 1 <= n <= 8
     * 2. The solution set must not contain duplicate combinations.
     * 
     * Example:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * 
     * @param n - Number of pairs of parentheses.
     * @returns List<String> - A list of all combinations of well-formed parentheses.
     */
    public void solve(int n,String curr,int open,int close,List<String>ans){
        if(curr.length()==2*n){
            ans.add(curr);
            return;
        }
        if(open<n){
                solve(n,curr+'(',open+1,close,ans);
        }
        if(close<open){
            solve(n,curr+')',open,close+1,ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        solve(n,"",0,0,ans);
        return ans;
    }
    //  * Main method for testing the GenerateParenthesis class.
    //  */
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        int n = 3;
        List<String> result = gp.generateParenthesis(n);
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        
        assert result.size() == expected.size() && result.containsAll(expected) : "Test case failed";
    }
}