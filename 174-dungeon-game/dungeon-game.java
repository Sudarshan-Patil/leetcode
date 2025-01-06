class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getHealth(0, 0, dungeon, dp, n, m);
    }

    public int getHealth(int i, int j, int[][] dungeon, int[][] dp, int n, int m) {
        if (i == n-1 && j == m-1) {
            return  Math.max(1, 1-dungeon[i][j]);
        }

        if (i>=n || j>=m) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = getHealth(i+1, j, dungeon, dp, n, m);
        int b = getHealth(i, j+1, dungeon, dp, n, m);

        dp[i][j] = Math.max(1, Math.min(a,b)-dungeon[i][j]);

        return dp[i][j];
    }
}