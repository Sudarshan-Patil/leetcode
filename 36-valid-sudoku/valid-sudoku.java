class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.' && !isValid(i, j, board, hs)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(int i, int j, char[][] board, HashSet<String> hs) {
        if (
            !hs.contains("row"+i+board[i][j]) &&
            !hs.contains("col"+j+board[i][j]) &&
            !hs.contains("box"+(i/3)+(j/3)+board[i][j])
        ) {
            hs.add("row"+i+board[i][j]);
            hs.add("col"+j+board[i][j]);
            hs.add("box"+(i/3)+(j/3)+board[i][j]);
            return true;
        }
        return false;
    }
}