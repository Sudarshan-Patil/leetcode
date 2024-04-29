class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = nums[0];

        for (int i=1; i<nums.length; i++) {
            ans ^= nums[i];
        }

        int count = 0;
        while (ans!=0 || k!=0) {
            if ((ans&1) != (k&1)) {
                count++;
            }
            ans = ans>>1;
            k = k>>1;
        }

        return count;
    }
}