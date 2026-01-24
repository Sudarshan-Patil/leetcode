class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i=0;
        int j=nums.length-1;

        while (i<j) {
            int sum = nums[i++] + nums[j--];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}