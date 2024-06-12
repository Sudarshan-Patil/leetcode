class Solution {
    public void gameOfLife(int[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                int t =  getMax(i, j, board);
                if (board[i][j] == 1 && t >= 2 && t <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && t == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }

        return;
    }

    public int getMax(int i, int j, int[][] board) {
        int sum = 0;
        if (i>0) {
            sum += board[i-1][j]&1;
        }
        if (i<board.length-1) {
            sum += board[i+1][j]&1;
        }
        if (j>0) {
            sum += board[i][j-1]&1;
        }
        if (j<board[0].length-1) {
            sum += board[i][j+1]&1;
        }

        if (i>0 && j>0) {
            sum += board[i-1][j-1]&1;
        }

        if (i<board.length-1 && j<board[0].length-1) {
            sum += board[i+1][j+1]&1;
        }

        if (i<board.length-1 && j>0) {
            sum += board[i+1][j-1]&1;
        }

        if (j<board[0].length-1 && i>0) {
            sum += board[i-1][j+1]&1;
        }

        return sum;
    }
}