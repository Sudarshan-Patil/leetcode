class Solution {
    public int[] rearrangeArray(int[] nums) {
        int no = nums.length/2;
        int[] p = new int[no];
        int[] n = new int[no];
        int pi = 0;
        int ni = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= 0) {
                p[pi++] = nums[i];
            } else {
                n[ni++] = nums[i];
            }
        }

        int[] ans = new int[no*2];
        int idx = 0;
        for (int i=0; i<no; i++) {
            ans[idx++] = p[i];
            ans[idx++] = n[i];
        }

        return ans;
    }
}