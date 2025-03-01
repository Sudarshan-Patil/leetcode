class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        int i=0;
        int j=0;

        while (i<n) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
            i++;
        }

        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

        return;
    }
}