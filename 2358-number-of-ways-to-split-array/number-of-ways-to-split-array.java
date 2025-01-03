class Solution {
    public int waysToSplitArray(int[] temp) {
        int n = temp.length;
        long[] nums = new long[n];
        nums[0] = temp[0];
        for (int i=1; i<n; i++) {
            nums[i] = nums[i-1] + temp[i];
        }

        int count = 0;
        for (int i=0; i<n-1; i++) {
            if (nums[i] >= nums[n-1]-nums[i]) {
                count++;
            }
        }

        return count;
    }
}