class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            int x = nums.get(i);
            int d = 1;
            int temp = -1;
            while ((x&d)!=0) {
                temp = x-d;
                d = d << 1;
            }

            ans[i] = temp;
        }

        return ans;
    }
}