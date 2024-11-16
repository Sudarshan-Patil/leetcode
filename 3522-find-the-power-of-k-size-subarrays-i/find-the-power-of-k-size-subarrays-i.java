class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;
        for (int i=k-1; i<n; i++) {
            if (idx > 0 && ans[idx-1] != -1 && nums[i] == nums[i-1]+1) {
                ans[idx++] = nums[i];
            } else if (isValid(nums, i-k+1, i)) {
                ans[idx++] = nums[i];
            } else {
                ans[idx++] = -1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] nums, int i, int j) {
        while (i<j) {
            if (nums[i] + 1 != nums[i+1]) {
                return false;
            }
            i++;
        }

        return true;
    }
}