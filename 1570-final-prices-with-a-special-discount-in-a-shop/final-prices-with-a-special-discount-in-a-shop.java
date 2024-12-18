class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st= new Stack<>();
        int len = prices.length;
        int[] ans = new int[len];
        for (int i=len-1; i>=0; i--) {
            while (!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? prices[i]-st.peek() : prices[i];
            st.push(prices[i]);
        }

        return ans;
    }
}