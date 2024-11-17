class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k<=0 || prices.length <= 0) {
            return 0;
        }

       
        int[] buy = new int[k];
        int[] sell = new int[k];

        Arrays.fill(buy, Integer.MAX_VALUE);
        Arrays.fill(sell, 0);

        for (int i=0; i<prices.length; i++) {
            for (int j=0; j<k; j++) {
                buy[j] = Math.min(buy[j], prices[i]-(j>0 ? sell[j-1] : 0));
                sell[j] = Math.max(sell[j], prices[i]-buy[j]);
            }
        }

        return sell[k-1];
    }

    public int help(int[] prices) {
        int sum = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                sum += prices[i]-prices[i-1];
            }
        }

        return sum;
    }
}