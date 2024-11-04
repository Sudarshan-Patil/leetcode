class Solution {
    public int jump(int[] nums) {
        int currentJump = 0;
        int maxJump = 0;
        int count = 0;
        for (int i=0; i<nums.length-1; i++) {
            maxJump = Math.max(maxJump, i+nums[i]);
            
            if (i == currentJump) {
                count++;
                currentJump = maxJump;
            }
        }

        return count;
    }
}