class Solution {
    public int jump(int[] nums) {
        int maxIndex = 0;
        int n = nums.length;
        int count = 0;
        int currentIndex = 0;
        for (int i=0; i<n-1; i++) {
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if (currentIndex == i) {
                currentIndex = maxIndex;
                count++;
            }
        }

        return count;
    }
}