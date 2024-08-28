class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1 && !vis[i][j]) {
                    if (check(i, j, grid1, grid2, vis)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean check(int i, int j, int[][] grid1, int[][] grid2, boolean[][] vis) {
        if (i<0 || i>=grid2.length || j<0 || j>=grid2[0].length || grid2[i][j] == 0 || vis[i][j]) {
            return true;
        }

        if (grid1[i][j] == 0) {
            return false;
        }

        vis[i][j] = true;

        for (int k=0; k<4; k++) {
            int x = i+dx[k];
            int y = j+dy[k];
            if (!check(x, y, grid1, grid2, vis)) {
                vis[i][j] = false;
                return false;
            }
        }

        return true;
    }
}