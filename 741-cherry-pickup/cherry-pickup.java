class Solution {
    int[][][] dp = new int[50][50][50];
    public int cherryPickup(int[][] grid) {
        for (int i=0; i<50; i++) {
            for (int j=0; j<50; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return Math.max(0, helper(0, 0, 0, grid, grid.length));
    }

    public int helper(int r1, int c1, int c2, int[][] grid, int n) {
        int r2 = r1+c1-c2;

        if (r1>=n || c1>=n || r2 >=n || c2>=n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n-1 && c1 == n-1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][c2] != -1) {
            return dp[r1][c1][c2];
        }

        int ans = grid[r1][c1];
        if (c1 !=c2) {
            ans += grid[r2][c2];
        }

        int a = helper(r1+1, c1, c2, grid, n);
        int b = helper(r1, c1+1, c2+1, grid, n);
        int c = helper(r1+1, c1, c2+1, grid, n);
        int d = helper(r1, c1+1, c2, grid, n);

        ans += Math.max(Math.max(a, b), Math.max(c, d));

        dp[r1][c1][c2] = ans;

        return ans;
    }
}