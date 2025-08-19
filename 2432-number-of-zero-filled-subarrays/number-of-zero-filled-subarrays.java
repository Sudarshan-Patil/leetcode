class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long currentStreak = 0;
        
        for (int num : nums) {
            if (num == 0) {
                // Increment the streak length
                currentStreak++;
                // Add the streak contribution
                ans += currentStreak;
            } else {
                // Reset the streak when non-zero is found
                currentStreak = 0;
            }
        }
        
        return ans;
    }
}