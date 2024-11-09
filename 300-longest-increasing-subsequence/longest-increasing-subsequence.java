class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        for (int i=0; i<nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMax(0, -1, nums);
    }

    public int getMax(int i, int j, int[] nums) {
        if (i==nums.length) {
            return 0;
        }

        if (dp[i][j+1] == -1) {
            dp[i][j+1] = getMax(i+1, j, nums);
            if (j==-1 || nums[j] < nums[i]) {
                dp[i][j+1] = Math.max(dp[i][j+1], getMax(i+1, i, nums) + 1);
            }
        }

        return dp[i][j+1];
    }
}