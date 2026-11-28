/*
Problem: N-Queens (LeetCode 51)
Category: Backtracking
Difficulty: Hard

Description:
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Approach:
Branch-and-Bound Backtracking:
1. Use a 1D array `x` where `x[k] = i` represents placing a queen at row `k`, column `i`.
2. Row-by-row placement naturally ensures no two queens share the same row.
3. For each candidate column `i` in row `k`:
   - Validate column and diagonal safety against previous queens `j` (0 <= j < k):
     - Column conflict: `x[j] == i`
     - Diagonal conflict: `|x[j] - i| == |j - k|`
4. If position `(k, i)` is safe:
   - Place queen: `x[k] = i`.
   - If row `k == n - 1`, a valid board configuration is complete -> construct and record board.
   - Otherwise, recurse to place queen in row `k + 1`.
5. Backtrack automatically by overwriting `x[k]` on next loop iteration.

Time Complexity: O(n!) — bounded by factorial permutation search space, heavily pruned by conflict constraints
Space Complexity: O(n) auxiliary space for recursion stack and position array x[] (excluding O(n^2) output list)
*/

import java.util.*;

class NQueens 
{
    private static int[] x;
    private static int size;

    public static List<List<String>> solveNQueens(int n) 
    {
        size = n;
        x = new int[n];
        List<List<String>> result = new ArrayList<>();

        nQueens(0, result);
        return result;
    }

    private static void nQueens(int k, List<List<String>> result) 
    {
        for (int i = 0; i < size; i++) 
        {
            if (place(k, i)) 
            {
                x[k] = i;

                if (k == size - 1) 
                {
                    result.add(createBoard());
                } 
                else 
                {
                    nQueens(k + 1, result);
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

    private static List<String> createBoard() 
    {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < size; i++) 
        {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < size; j++) 
            {
                if (x[i] == j) 
                {
                    row.append("Q");
                } 
                else 
                {
                    row.append(".");
                }
            }

            board.add(row.toString());
        }

        return board;
    }

    public static void main(String[] args) 
    {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        System.out.println("N-Queens solutions for n = 4 (" + solutions.size() + " total):");
        for (List<String> board : solutions) 
        {
            for (String row : board) 
            {
                System.out.println("  " + row);
            }
            System.out.println();
        }
    }
}
