class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return getMax(0, 1, prices, dp, n);
    }

    public int getMax(int index, int buy, int[] prices, int[][] dp, int n) {
        if (index >= n) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int max = 0;
        if (buy == 1) {
            max = Math.max(
                -prices[index] + getMax(index+1, 0, prices, dp, n),
                0 + getMax(index+1, 1, prices, dp, n)
            );
        } else {
            max = Math.max(
                prices[index] + getMax(index+2, 1, prices, dp, n),
                0 + getMax(index+1, 0, prices, dp, n)
            );
        }

        return dp[index][buy] = max;
    }
}