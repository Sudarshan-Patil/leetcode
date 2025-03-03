class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less = 0;
        int equal = 0;
        int greater = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] < pivot) {
                less++;
            } else if (nums[i] == pivot) {
                equal++;
            }
        }

        greater = less + equal;
        equal = less;
        less = 0;

        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            if (nums[i] < pivot) {
                ans[less++] = nums[i];
            } else if (nums[i] == pivot) {
                ans[equal++] = nums[i];
            } else {
                ans[greater++] = nums[i];
            }
        }
         
         return ans;
    }
}