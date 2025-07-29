class Solution {
    int max = 0;
    public int countMaxOrSubsets(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            max |= nums[i];
        }

        return dfs(0, nums, 0);
    }

    public int dfs(int i, int[] nums, int sum) {
        if (i == nums.length) {
            if (sum == max) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(i+1, nums, sum) + dfs(i+1, nums, (sum | nums[i]));
    }
}