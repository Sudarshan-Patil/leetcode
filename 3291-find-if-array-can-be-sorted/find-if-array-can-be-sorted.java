class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] tempArr = new int[n];
        for (int i=0; i<32; i++) {
            for (int j=0; j<nums.length; j++) {
                int num = nums[j]>>i;

                if ((num&1) == 1) {
                    tempArr[j] += 1;
                }
            }
        }

        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length-1; j++) {
                if (nums[j] > nums[j+1] && tempArr[j] == tempArr[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }

        for (int i=0; i<n-1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }

        return true;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }
}