class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;

        for (int i=1; i<prices.length; i++) {
            if (buy < prices[i]) {
                ans += prices[i]-buy;
                buy = prices[i];
            } else {
                buy = prices[i];
            }
        }

        return ans;
    }
}