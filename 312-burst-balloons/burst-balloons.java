class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMax(0, nums.length-1, nums, dp);
    }

    public int getMax(int i, int j, int[] nums, int[][] dp) {
        if (i>j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = 0;
        for (int ind=i; ind<=j; ind++) {
            int step = getMax(i, ind-1, nums, dp) + getMax(ind+1, j, nums, dp) + ((i>0 ? nums[i-1] : 1)*nums[ind]*(j<nums.length-1 ? nums[j+1] : 1));
            max = Math.max(max, step);
        }

        return dp[i][j] = max;
    }
}