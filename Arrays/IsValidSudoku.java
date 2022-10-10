/*
Problem URL: https://leetcode.com/problems/valid-sudoku/

Problem Statement: 
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[] row = new int[n];
        int[] col = new int[n];
        int[] box = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j];
                if ((row[i] & 1 << val) > 0) return false;
                row[i] |= (1 << val);

                if ((col[j] & 1 << val) > 0) return false;
                col[j] |= (1 << val);
                
                int k = (i / 3) * 3 + (j / 3);
                if ((box[k] & 1 << val) > 0) return false;
                box[k] |= (1 << val);
            }
        }
        return true;
    }
    
    public boolean isValidSudokuBF(char[][] board) {
        Set<Character> set = new HashSet<>(9);
        //Checking Rows
        for (char[] row : board) {
            for (char element : row) {
                if (element == '.') continue;
                boolean flag = set.add(element);
                if (!flag) return false;
            }
            set.clear();
        }
        //Checking Column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                boolean flag = set.add(board[j][i]);
                if (!flag) return false;
            }
            set.clear();
        }
        //3 x 3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();        
        /* ------------------------------------------- */
        
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();        
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();
        /* ------------------------------------------- */
        
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = set.add(board[i][j]);
                if (!flag) return false;
            }
        }
        set.clear();
        return true;
    }
}
