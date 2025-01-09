class Solution {
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            total += nums[i];
        }
        Integer[][] dp = new Integer[n][total*2+1];

        return getSum(0, nums, target, 0, dp);
    }

    public int getSum(int index, int[] nums, int target, int sum, Integer[][] dp) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        if (dp[index][sum+total] != null) {
            return dp[index][sum+total];
        }
        
        int add = getSum(index+1, nums, target, sum + nums[index], dp);
        int subtract = getSum(index+1, nums, target, sum-nums[index], dp);

        return dp[index][sum+total] = add+subtract;
    }
}