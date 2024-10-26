class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (stringExists(i, j, n, m, 0, word, board, vis)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean stringExists(int i, int j, int n, int m, int idx, String word, char[][] board, boolean[][] vis) {
        if (idx == word.length()) {
            return true;
        }
        
        if (i<0 || i>=n || j<0 || j>=m || word.charAt(idx) != board[i][j] || vis[i][j]) {
            return false;
        }

        vis[i][j] = true;
        for (int k=0; k<4; k++) {
            int x = i+dx[k];
            int y = j+dy[k];
            if (stringExists(x, y, n, m, idx+1, word, board, vis)) {
                return true;
            }
        }
        vis[i][j] = false;

        return false;
    }
}