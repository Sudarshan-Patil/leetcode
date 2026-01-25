class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (k>n) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i=k-1, j=0; i<n; i++, j++) {
            int sum = nums[i]-nums[j];
            ans = Math.min(ans, sum);
        }

        return ans;
    }
}