class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i=1; i<n; i++) {
            nums[i] += nums[i-1];
        }

        for (int i=1; i<n; i++) {
            int x = nums[i-1];
            int y = nums[n-1]-nums[i-1];

            int t = Math.abs(x-y);
            if (t%2 == 0) {
                count++;
            }
        }

        return count;
    }
}