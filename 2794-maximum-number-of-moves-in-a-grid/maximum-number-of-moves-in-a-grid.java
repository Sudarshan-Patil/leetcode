class Solution {
    int[][] dp;
    public int maxMoves(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i=0; i<n; i++) {
            ans = Math.max(ans, dfs(i, 0, n, m, grid, -1)-1);
        }

        return ans;
    }

    public int dfs(int i, int j, int n, int m, int[][] grid, int parent) {
        if (i<0 || i>=n || j<0 || j>=m || grid[i][j] <= parent) {
            return 0;
        }

        if (dp[i][j] == -1) {
            dp[i][j] = Math.max(Math.max(dfs(i-1, j+1, n, m, grid, grid[i][j]),
                    dfs(i, j+1, n, m, grid, grid[i][j])),
                    dfs(i+1, j+1, n, m, grid, grid[i][j])) + 1;
        }

        return dp[i][j];
    }
}