package Recursion;
import java.util.*;

public class solveNQueens {

    public boolean isValid(char[][] board, int r, int col, int n) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = r - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = r - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void f(List<List<String>> ans, char[][] board, int r, int n) {
        if (r >= n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, r, col, n)) {
                board[r][col] = 'Q';
                f(ans, board, r + 1, n);
                board[r][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        f(ans, board, 0, n);
        return ans;
    }

    // Optional helper if you want to count total solutions
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

    public static void main(String[] args) {
        solveNQueens nQueens = new solveNQueens();

        // Test cases
        assert nQueens.totalNQueens(4) == 2 : "Test case 1 failed";
        assert nQueens.totalNQueens(1) == 1 : "Test case 2 failed";
        assert nQueens.totalNQueens(5) == 10 : "Test case 3 failed";
    }
}
