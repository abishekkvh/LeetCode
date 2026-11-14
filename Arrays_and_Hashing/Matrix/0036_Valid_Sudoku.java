/*
Problem: Valid Sudoku (LeetCode 36)
Category: Arrays & Hashing / Matrix
Difficulty: Medium

Approach:
1. Validate rows: Use a HashSet per row to ensure numbers 1-9 appear without repetition.
2. Validate columns: Use a HashSet per column to ensure numbers 1-9 appear without repetition.
3. Validate 3x3 sub-boxes: Iterate through each of the 9 sub-boxes (step size 3), using a HashSet to detect duplicates.
4. If any duplicate non-empty cell ('.') is found, return false. Otherwise, return true.

Time Complexity: O(1) - fixed 9x9 board (81 cells scanned a constant number of times)
Space Complexity: O(1) - at most 9 elements per HashSet
*/

import java.util.*;

class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }
            }

            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) {
                        return false;
                    }
                    col.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<Character> box = new HashSet<>();

                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            if (box.contains(board[k][l])) {
                                return false;
                            }
                            box.add(board[k][l]);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
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

        System.out.println(isValidSudoku(board));
    }
}
