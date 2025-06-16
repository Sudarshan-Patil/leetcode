class Solution {
    public int maximumDifference(int[] nums) {
        int mini = 0;
        int maxi = 0;
        int ans = -1;

        for (int i=0; i<nums.length; i++) {
            if (nums[mini] > nums[i]) {
                mini = i;
                maxi = i;
            }
            if (nums[maxi] < nums[i]){
                maxi = i;
            }

            if (maxi > mini) {
                ans = Math.max(ans, nums[maxi]-nums[mini]);
            }
        }

        return ans;
    }
}