class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int total = 0;

        for (int i=0; i<nums.length; i++) {
            currMax = Math.max(currMax, 0)+nums[i];
            max = Math.max(max, currMax);

            currMin = Math.min(currMin, 0)+nums[i];
            min = Math.min(min, currMin);

            total += nums[i];
        }

        if (total == min) {
            return max;
        }

        return Math.max(max, total-min);
    }
}