class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return getMax(nums, 0, n, dp);
    }

    public int getMax(int[] num, int i, int n, int[] dp) {
        if (i>=n) {
            return 0;
        }

        if (dp[i] == -1) {
            dp[i] = Math.max(getMax(num, i+1, n, dp), getMax(num, i+2, n, dp) + num[i]);
        }

        return dp[i];
    }
}