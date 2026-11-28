/*
Problem: N-Queens II (LeetCode 52)
Category: Backtracking
Difficulty: Hard

Description:
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Approach:
Branch-and-Bound Backtracking:
1. Maintain position array `x` where `x[k] = i` records placing a queen at row `k`, column `i`.
2. Row-by-row placement guarantees at most one queen per row.
3. For row `k`, iterate column `i` from 0 to n - 1:
   - Check if `(k, i)` conflicts with any placed queen `(j, x[j])` where `0 <= j < k`:
     - Same column: `x[j] == i`
     - Same diagonal: `|x[j] - i| == |j - k|`
4. If safe:
   - Set `x[k] = i`.
   - If row `k == n - 1`, increment the valid configuration count.
   - Otherwise, recurse to row `k + 1`.
5. Backtracking occurs implicitly upon returning from recursive branch.

Time Complexity: O(n!) — bounded by search space with aggressive conflict pruning
Space Complexity: O(n) for recursion call stack and position array x[]
*/

class NQueensII 
{
    private static int[] x;
    private static int size;
    private static int count;

    public static int totalNQueens(int n) 
    {
        size = n;
        x = new int[n];
        count = 0;

        nQueens(0);
        return count;
    }

    private static void nQueens(int k) 
    {
        for (int i = 0; i < size; i++) 
        {
            if (place(k, i)) 
            {
                x[k] = i;

                if (k == size - 1) 
                {
                    count++;
                } 
                else 
                {
                    nQueens(k + 1);
                }
            }
        }
    }

    private static boolean place(int k, int i) 
    {
        for (int j = 0; j < k; j++) 
        {
            if (x[j] == i) 
            {
                return false;
            }

            if (Math.abs(x[j] - i) == Math.abs(j - k)) 
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) 
    {
        int n1 = 4;
        System.out.println("Total solutions for n = 4: " + totalNQueens(n1)); // Expected: 2

        int n2 = 1;
        System.out.println("Total solutions for n = 1: " + totalNQueens(n2)); // Expected: 1
    }
}
