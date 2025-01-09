class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getCount(n-1, amount, coins, dp);
    }

    public int getCount(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }

        if (i<0) {
            return 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int a = getCount(i-1, amount, coins, dp);
        if (amount >= coins[i]) {
            a += getCount(i, amount-coins[i], coins, dp);
        }

        return dp[i][amount] = a;
    }
}