class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        int n = nums.length;
        while (i<n) {
            if (nums[i] == 1) {
                break;
            }
            i++;
        }

        for (int j=i+1; j<n; j++) {
            if (nums[j] == 1) {
                if (j-i <= k) {
                    return false;
                }
                i=j;
            }
        }

        return true;
    }
}