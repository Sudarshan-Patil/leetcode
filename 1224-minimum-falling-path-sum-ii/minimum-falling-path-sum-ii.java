class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        int n = grid.length;

        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<grid[0].length; i++) {
            ans = Math.min(ans, getMin(1, i, grid, n) + grid[0][i]);
        }
        
        return ans;
    }

    public int getMin(int i, int j, int[][] grid, int n) {
        if (i == n) {
            return 0;
        }

        if (dp[i][j] == -1) {
            int a = Integer.MAX_VALUE;
            for (int k=0; k<grid[0].length; k++) {
                if (k == j) {
                    continue;
                }

                a = Math.min(a, getMin(i+1, k, grid, n) + grid[i][k]);
            }
            dp[i][j] = a;
        }

        return dp[i][j];
    }
}