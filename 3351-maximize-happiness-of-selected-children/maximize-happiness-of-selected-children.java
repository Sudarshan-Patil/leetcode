class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int i = n-1;
        long carry = 0;
        long ans = 0;
        while (k > 0 && i >= 0) {
            ans += Math.max(0, happiness[i] - carry);
            if (happiness[i] - carry <= 0) {
                break;
            }

            carry++;
            k--;
            i--;
        }

        return ans;
    }
}