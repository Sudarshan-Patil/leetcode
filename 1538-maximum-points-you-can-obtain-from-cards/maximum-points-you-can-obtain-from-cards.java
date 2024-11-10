class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += cardPoints[i];
        }
        int n = cardPoints.length;
        if (k == cardPoints.length) {
            return sum;
        }

        int ans = sum;
        int j = k-1;
        for (int i=n-1; i>=n-k; i--) {
            sum += cardPoints[i] - cardPoints[j--];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}