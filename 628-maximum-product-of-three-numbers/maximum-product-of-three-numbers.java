class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length-1;
        int ans = nums[len] * nums[len-1] * nums[len-2];

        ans = Math.max(ans, nums[0] * nums[1] * nums[len]);

        return ans;
    }
}