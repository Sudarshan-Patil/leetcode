class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0; 

        while (i<nums.length) {
            while (j>0 && i<nums.length && nums[i] == nums[j-1]) {
                i++;
            }
            if (i == nums.length) {
                break;
            }
            swap(nums, j, i);
            i++;
            j++;
        }

        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}