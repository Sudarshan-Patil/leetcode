class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return getSum(0, nums, target, 0);
    }

    public int getSum(int index, int[] nums, int target, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int ans = 0;
        int temp = nums[index];
        sum += temp;
        ans += getSum(index+1, nums, target, sum);
        sum -= temp;
        temp *= -1;
        sum += temp;
        ans += getSum(index+1, nums, target, sum);

        return ans;
    }
}