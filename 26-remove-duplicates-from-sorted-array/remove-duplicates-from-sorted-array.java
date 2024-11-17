class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int i = 0;
        int j = 0;
        while (j<nums.length) {
            if (j==0 || nums[j] == nums[j-1]) {
                ++count;
            } else {
                count = 1;
            }
            if (count <= 1) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }

     public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }
}