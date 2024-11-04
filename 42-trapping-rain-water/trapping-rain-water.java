class Solution {
    public int trap(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int rightMax = height[right];
        int leftMax = height[left];
        int water = 0;
        
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water = water + leftMax - height[left];
            }else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water = water + rightMax - height[right];
            }
        }

        return water;
    }
}