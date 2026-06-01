class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        for (int i=cost.length-1, j=0; i>=0; i--, j++) {
            if ((j+1)%3 == 0) {
                //
            } else {
                ans += cost[i];
            }
        }

        return ans;
    }
}