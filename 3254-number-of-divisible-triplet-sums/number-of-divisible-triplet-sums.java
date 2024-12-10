class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, List<int[]>> dupletSums = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = (nums[i] + nums[j]) % d;
                dupletSums.putIfAbsent(temp, new ArrayList<>());
                dupletSums.get(temp).add(new int[]{i, j});
            }
        }

        for (int k = 0; k < nums.length; k++) {
            // x + y MOD d == 0 is congruent to (x MOD d + y MOD d) MOD d == 0
            // One solution is (x MOD d + y MOD d) == d

            int val = nums[k];
            int targetKey = (d - val % d) % d;
            final int kFinal = k;

            ans += dupletSums.getOrDefault(targetKey, Collections.emptyList())
                    .stream()
                    .filter(ijPair -> ijPair[1] < kFinal)
                    .count();
        }

        return ans;
    }
}