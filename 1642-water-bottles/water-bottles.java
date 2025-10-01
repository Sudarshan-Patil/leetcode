class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int n = numBottles/numExchange;
        int carry = numBottles%numExchange;

        while (n>0) {
            ans += n;
            n+=carry;
            carry = n%numExchange;
            n = n/numExchange;
        }

        return ans;
    }
}