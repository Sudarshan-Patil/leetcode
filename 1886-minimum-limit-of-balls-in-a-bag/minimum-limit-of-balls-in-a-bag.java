class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int i=0; i<nums.length; i++) {
            right = Math.max(right, nums[i]);
        }
        int ans = 0;
        while (left < right) {
            int mid = (left+right)/2;

            if (isValid(mid, nums, maxOperations)) {
                ans = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean isValid(int middle, int[] nums, int max) {
        int op = 0;

        for (int i=0; i<nums.length; i++) {
            op += (int)Math.ceil(nums[i]/(double)middle)-1;

            if (op > max) {
                return false;
            }
        }

        return true;
    }
}