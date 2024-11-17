class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (j<nums.length) {
            if (sum + nums[j] < target) {
                sum += nums[j];
                j++;
            } else {
                len = Math.min(len, j-i+1);
                sum -= nums[i];
                i++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}