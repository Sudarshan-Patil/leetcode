class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> row = new HashSet<>();
        HashSet<String> col = new HashSet<>();
        HashSet<String> box = new HashSet<>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.' && !isValid(i, j, board, row, col, box)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(int i, int j, char[][] board, HashSet<String> row, HashSet<String> col, HashSet<String> box) {
        if (
            !row.contains("row"+i+board[i][j]) &&
            !col.contains("col"+j+board[i][j]) &&
            !box.contains("box"+(i/3)+(j/3)+board[i][j])
        ) {
            row.add("row"+i+board[i][j]);
            col.add("col"+j+board[i][j]);
            box.add("box"+(i/3)+(j/3)+board[i][j]);
            return true;
        }
        return false;
    }
}