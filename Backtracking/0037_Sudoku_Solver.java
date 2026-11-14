/*
Problem: Sudoku Solver (LeetCode 37)
Category: Backtracking
Difficulty: Hard

Approach:
1. Scan the 9x9 board cell-by-cell for empty cells ('.').
2. When an empty cell (row, col) is found:
   - Try placing digits '1' through '9'.
   - Validate if placing digit 'k' is legal (check current row, column, and 3x3 box for duplicates).
   - If valid, assign board[row][col] = k and recursively call solve(board).
   - If recursive call succeeds, return true.
   - If no digit leads to a solution, backtrack by resetting board[row][col] = '.' and return false.
3. If no empty cell remains, the puzzle is solved -> return true.

Time Complexity: O(9^(empty cells)) in the worst case, but heavily pruned by validity constraints
Space Complexity: O(empty cells) recursion stack depth (at most 81 frames)
*/

import java.util.Arrays;

class SudokuSolver {
    static char[][] board = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    static boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }

            if (board[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;

                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveSudoku(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
