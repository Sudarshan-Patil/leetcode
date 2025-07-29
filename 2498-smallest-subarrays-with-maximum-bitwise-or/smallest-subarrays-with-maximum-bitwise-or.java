class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] ans = new int[nums.length];
        int[] bitMask = new int[32]; // Enough for 32-bit integers
        Arrays.fill(bitMask, Integer.MAX_VALUE);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            // Track the farthest position needed for current maximum OR
            int lastIndex = i;
            
            // Update bit positions with current number's bits
            updateBitMask(bitMask, nums[i], i);
            
            // Find the farthest position where any bit is set
            for (int j = 0; j < 32; j++) {
                if (bitMask[j] != Integer.MAX_VALUE) {
                    lastIndex = Math.max(lastIndex, bitMask[j]);
                }
            }
            
            // Calculate subarray length
            ans[i] = lastIndex - i + 1;
        }
        return ans;
    }

    private void updateBitMask(int[] bitMask, int num, int pos) {
        int index = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                bitMask[index] = pos; // Update with current position
            }
            num >>= 1;
            index++;
        }
    }
}