/*
Problem: Unique Paths (LeetCode 62)
Category: Dynamic Programming / 2D Grid
Difficulty: Medium

Approach:
1. Define dp[i][j] as number of unique paths from (i, j) to destination (m-1, n-1).
2. Base cases:
   - All cells in the bottom row (m-1) have only 1 path (can only move Right).
   - All cells in the rightmost column (n-1) have only 1 path (can only move Down).
3. Recurrence relation:
   dp[i][j] = dp[i+1][j] + dp[i][j+1]
4. Return dp[0][0].

Time Complexity: O(m * n)
Space Complexity: O(m * n)
*/

class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 1;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                result[i][j] = result[i + 1][j] + result[i][j + 1];
            }
        }

        return result[0][0];
    }

    public static void main(String[] args) {
        int noOfUniquePaths = uniquePaths(3, 7);
        System.out.println(noOfUniquePaths);
    }
}

