class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] <= buy) {
                buy = prices[i];
            } else {
                ans = Math.max(ans, prices[i]-buy);
            }
        }

        return ans;
    }
}