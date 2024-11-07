class Solution {
    public int largestCombination(int[] candidates) {
        int[] arr = new int[32];
        int n = candidates.length;
        for (int i=0; i<32; i++) {
            for (int j=0; j<n; j++) {
                if ((candidates[j]&1) == 1) {
                    arr[i]++;
                }
                candidates[j] = candidates[j]>>1;
            }
        }
        int ans = 0;
        for (int i=0; i<32; i++) {
            ans = Math.max(ans, arr[i]);
        }

        return ans;
    }
}