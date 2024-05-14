class Solution {
    boolean[][] vis;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        vis = new boolean[n][m];
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] > 0) {
                    ans = Math.max(ans, dfs(grid, i, j, n, m));
                }
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public int dfs(int[][] grid, int i, int j, int n, int m) {
        if (i>=n || j>=m || i<0 || j<0 || grid[i][j] == 0 || vis[i][j]) {
            return 0;
        }

        int temp = Integer.MIN_VALUE;
        for (int k=0; k<4; k++) {
            int x = i+dx[k];
            int y = j+dy[k];
            vis[i][j] = true;
            temp = Math.max(temp, dfs(grid,x, y, n, m) + grid[i][j]);
            vis[i][j] = false;
        }

        return temp;
    }
}