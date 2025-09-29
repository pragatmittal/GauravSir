package Recursion;
public class SearchMatrix {
    /**
     * Search a 2D matrix.
     * 
     * You are given an m x n integer matrix matrix with the following two properties:
     * 1. Each row is sorted in non-decreasing order.
     * 2. Each column is sorted in non-decreasing order.
     * 
     * Given an integer target, return true if target is in matrix or false otherwise.
     * 
     * Constraints:
     * 1. m == matrix.length
     * 2. n == matrix[i].length
     * 3. 1 <= m, n <= 300
     * 4. -10^9 <= matrix[i][j] <= 10^9
     * 
     * @param matrix - A 2D list of integers representing the matrix.
     * @param target - The integer to search for in the matrix.
     * @returns boolean - True if target is found in the matrix, otherwise false.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = solve(0, matrix[0].length - 1, matrix.length - 1, matrix[0].length - 1, matrix, target);
        return ans;
    }

    private boolean solve(int rs, int cs, int re, int ce, int[][] matrix, int target) {
        if (rs > re || cs > ce) {
            return false;
        }
        
        int rm = rs + (re - rs) / 2;
        int cm = cs + (ce - cs) / 2;
        int curr = matrix[rm][cm];

        if (curr == target) {
            return true;
        }

        boolean ans = false;

        // if ()

        return ans;
    }

    /**
     * Main method for testing the SearchMatrix class.
     */
    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        
        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        assert sm.searchMatrix(matrix1, 5) == true : "Test case 1 failed";
        assert sm.searchMatrix(matrix1, 20) == false : "Test case 2 failed";

        int[][] matrix2 = {
            {-1, 3}
        };
        assert sm.searchMatrix(matrix2, 3) == true : "Test case 3 failed";
        assert sm.searchMatrix(matrix2, -1) == true : "Test case 4 failed";
        assert sm.searchMatrix(matrix2, 0) == false : "Test case 5 failed";
    }
}
