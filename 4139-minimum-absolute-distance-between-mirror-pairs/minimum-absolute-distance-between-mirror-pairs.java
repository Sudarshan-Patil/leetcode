class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans = nums.length+1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> hmr = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int t = reverse(nums[i]);
            if (hmr.containsKey(nums[i])) {
                ans = Math.min(ans, i-hmr.get(nums[i]));
            }
            hmr.put(t, i);
        }

        return ans != nums.length+1 ? ans : -1;
    }

    public int reverse(int n) {
        int t = 0;
        while(n>0) {
            t*=10;
            t += n%10;
            n/=10;
        }

        return t;
    }
}