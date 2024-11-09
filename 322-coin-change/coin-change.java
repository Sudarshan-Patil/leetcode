class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = getMin(0, amount, coins);

        return ans == 10001 ? -1 : ans;
    }

    public int getMin(int i, int j, int[] coins) {
        if (j == 0) {
            return 0;
        }

        if (i>=coins.length || j<0) {
            return 10001;
        }

        if (dp[i][j] == -1) {
            int a = getMin(i+1, j, coins);
            if (j>=coins[i]) {
                a = Math.min(a, getMin(i, j-coins[i], coins)+1);
            }
            dp[i][j] = a;
        }

        return dp[i][j];
    }
}