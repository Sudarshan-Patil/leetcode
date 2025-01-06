class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            sum += nums[i];
        }

        if (sum%2 != 0) {
            return false;
        }

        int target = sum/2;
        Boolean[][] dp = new Boolean[n][target+1];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], null);
        }

        return helper(0, target, nums, dp);
    }

    public boolean helper(int i, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (i>=nums.length) {
            return false;
        }

        if (dp[i][target] != null) {
            return (boolean)dp[i][target];
        }

        boolean flag = helper(i+1, target, nums, dp);
        if (target >= nums[i]) {
            flag |= helper(i+1, target-nums[i], nums, dp);
        }
        dp[i][target] = flag;
        return flag;
    }
}