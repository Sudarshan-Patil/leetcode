class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        long ans = 0;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        int n = nums.length;
        for (int i=2; i<n; i++) {
            right.put(nums[i], right.getOrDefault(nums[i], 0)+1);
        }

        left.put(nums[0], 1);

        for (int i=1; i<n-1; i++) {
            int temp = nums[i] * 2;
            if (left.containsKey(temp) && right.containsKey(temp)) {
                int n1 = left.get(temp);
                int n2 = right.get(temp);

                ans = (ans%mod + ((long)n1 * (long)n2)%mod)%mod;
            }

            left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
            
            right.put(nums[i+1], right.get(nums[i+1])-1);
            if (right.get(nums[i+1]) == 0) {
                right.remove(nums[i+1]);
            }
        }

        return (int)ans;
    }
}