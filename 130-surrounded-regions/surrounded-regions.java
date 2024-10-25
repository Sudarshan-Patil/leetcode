class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <=2) {
            return ;
        } 
        
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 || i==m-1 || j==0 || j==n-1) {
                    if (board[i][j] == 'O') {
                        flip(i, j, board);
                    }
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }

    public void flip(int i, int j, char[][] board) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == 'X' || board[i][j] == '*') {
            return;
        }

        board[i][j] = '*';
        for (int k=0; k<4; k++) {
            flip(i+dx[k], j+dy[k], board);
        }
        return;
    }
}