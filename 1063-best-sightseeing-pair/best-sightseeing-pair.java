class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int best = values[0];
        for (int i=1; i<values.length; i++) {
            ans = Math.max(ans, best + values[i]-i);
            best = Math.max(best, values[i]+i);
        }

        return ans;
    }
}