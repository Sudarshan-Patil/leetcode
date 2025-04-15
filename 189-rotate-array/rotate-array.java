class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        rotate(nums, 0, n-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, n-1);
        
        return;
    }

    public void rotate(int[] nums, int i, int j) {
        while (i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return;
    }
}