class Solution {
    public int matrixSum(int[][] nums) {
        for (int i=0; i<nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int ans = 0;
        for (int j=nums[0].length-1; j>=0; j--) {
            int max = Integer.MIN_VALUE;
            for (int i=0; i<nums.length; i++) {
                max = Math.max(max, nums[i][j]);
            }
            ans += max;
        }

        return ans;
    }
}