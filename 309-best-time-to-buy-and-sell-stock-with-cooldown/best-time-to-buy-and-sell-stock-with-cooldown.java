class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMax(0, prices.length, prices, dp);
    }

    public int getMax(int index, int n, int[] prices, int[] dp) {
        if (index>=n) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }

        int a = getMax(index+1, n, prices, dp);
        for (int i=index+1; i<n; i++) {
            a = Math.max(a, getMax(i+2, n, prices, dp) + (prices[i]-prices[index]));
        }

        return dp[index] = a;
    }
}