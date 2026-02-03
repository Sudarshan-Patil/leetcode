class Solution {
    public boolean isTrionic(int[] nums) {
        int i=1;
        int n = nums.length;
        while(i<n) {
            if (nums[i] <= nums[i-1]) {
                break;
            }
            i++;
        }
        if (i==1) {
            return false;
        }

        while(i<n) {
            if (nums[i] >= nums[i-1]) {
                break;
            }
            i++;
        }
        if (i==n) {
            return false;
        }

        while(i<n) {
            if (nums[i] <= nums[i-1]) {
                break;
            }
            i++;
        }

        if (i==n) {
            return true;
        }
        return false;
    }
}