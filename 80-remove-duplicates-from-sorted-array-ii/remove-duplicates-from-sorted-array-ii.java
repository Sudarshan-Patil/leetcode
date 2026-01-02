class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        int count = 0;
        int n = nums.length;
        while (j<n) {
            if (j == 0 || nums[j] == nums[j-1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}