class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int firstSell = 0;

        int secondBuy = Integer.MAX_VALUE;
        int secondSell = 0;

        for (int i=0; i<prices.length; i++) {
            firstBuy = Math.min(firstBuy, prices[i]);
            firstSell = Math.max(firstSell, prices[i]-firstBuy);

            secondBuy = Math.min(secondBuy, prices[i]-firstSell);
            secondSell = Math.max(secondSell, prices[i]-secondBuy);
        }

        return secondSell;
    }
}