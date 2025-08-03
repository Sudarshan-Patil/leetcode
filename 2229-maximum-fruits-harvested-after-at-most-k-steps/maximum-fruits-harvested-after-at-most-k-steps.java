class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;          // Left boundary of window
        int currentSum = 0;     // Current sum of fruits in window
        int maxFruits = 0;      // Maximum fruits collected
        
        for (int right = 0; right < fruits.length; right++) {
            // Add fruits at current right position
            currentSum += fruits[right][1];
            
            // Shrink window from left if steps exceed k
            while (left <= right && 
                   minSteps(fruits[left][0], fruits[right][0], startPos) > k) {
                currentSum -= fruits[left][1];
                left++;
            }
            
            // Update maximum fruits collected
            maxFruits = Math.max(maxFruits, currentSum);
        }
        
        return maxFruits;
    }

    private int minSteps(int leftPos, int rightPos, int start) {
        // Calculate steps for left-first path
        int goLeftFirst = Math.abs(start - leftPos) + (rightPos - leftPos);
        // Calculate steps for right-first path
        int goRightFirst = Math.abs(start - rightPos) + (rightPos - leftPos);
        // Return minimum steps between two paths
        return Math.min(goLeftFirst, goRightFirst);
    }
}