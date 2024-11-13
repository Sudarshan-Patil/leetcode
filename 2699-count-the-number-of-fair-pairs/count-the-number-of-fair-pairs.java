class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return getCount(nums, upper) - getCount(nums, lower-1);
    }

    public long getCount(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        long ans = 0;

        while (left<right) {
            long sum = nums[left]+nums[right];

            if (sum <= target) {
                ans += right-left;
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}