class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0]; 
        int min = nums[0]; 
        int ans = nums[0];
        int n = nums.length;
        
        for (int i = 1; i < n; i++) {
            int minNum = min;
            int maxNum = max;
            max = Math.max(nums[i], Math.max(maxNum * nums[i], minNum * nums[i]));
            min = Math.min(nums[i], Math.min(maxNum * nums[i], minNum * nums[i]));

            ans = Math.max(ans, max);
        }
        
        return ans;

    }
}