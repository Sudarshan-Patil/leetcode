class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] ans = new int[101];

        for (int i=0; i<nums.length; i++) {
            ans[nums[i]]++;
        }
        
        int max = 0;
        int index = 0;
        int sum = 0;

        for (int i=1; i<=100; i++) {
            if (max < ans[i]) {
                max = ans[i];
                sum = ans[i];
            } else if (max == ans[i]) {
                sum += ans[i];
            }
        }

        return sum;
    }
}