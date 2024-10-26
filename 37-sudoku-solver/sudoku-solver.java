class Solution {
    public void solveSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    hs.add("row" + i + board[i][j]);
                    hs.add("col" + j + board[i][j]);
                    hs.add("box" + (i/3) + (j/3) + board[i][j]);
                }
            }
        }

        generate(0, board, hs);

        return;
    }

    public boolean generate(int idx, char[][] board, HashSet<String> hs) {
        if (idx == 81) {
            return true;
        }

        int row = idx/9;
        int col = idx%9;

        if (board[row][col] == '.') {
            for (int i=1; i<=9; i++) {
                if (valid(row, col, i, hs)) {
                    updateHashSet(row, col, i, hs);
                    board[row][col] = (char)(i+'0');
                    if (generate(idx+1, board, hs)) {
                        return true;
                    }
                    board[row][col] = '.';
                    removeFromHashSet(row, col, i, hs);
                }
            }
        } else {
            if (generate(idx+1, board, hs)) {
                return true;
            }
        }

        return false;
    }

    public void updateHashSet(int row, int col, int i, HashSet<String> hs) {
        hs.add("row"+row+i);
        hs.add("col"+col+i);
        hs.add("box"+(row/3)+(col/3)+i);

        return;
    }

    public void removeFromHashSet(int row, int col, int i, HashSet<String> hs) {
        hs.remove("row"+row+i);
        hs.remove("col"+col+i);
        hs.remove("box"+(row/3)+(col/3)+i);

        return;
    }

    public boolean valid(int row, int col, int i, HashSet<String> hs) {
        if (
            !hs.contains("row"+row+i) &&
            !hs.contains("col"+col+i) &&
            !hs.contains("box"+(row/3)+(col/3)+i)
        ) {
            return true;
        }
        return false;
    }
}