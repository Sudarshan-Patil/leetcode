class Solution {
    public int findRotateSteps(String ring, String key) {
        int ringlen = ring.length();
        int keylen = key.length();
        int[][] dp = new int[ringlen][keylen];
        for (int i=0; i<ringlen; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getMinCount(ring, key, 0, 0, dp, ringlen, keylen);
    }

    public int getMinCount(String ring, String key, int ringIndex, int keyIndex, int[][] dp, int ringlen, int keylen) {
        if (keyIndex == keylen) {
            return 0;
        }

        if (dp[ringIndex][keyIndex] == -1) {
            int ans = Integer.MAX_VALUE;
            for (int i=0; i<ringlen; i++) {
                if (ring.charAt(i) == key.charAt(keyIndex)) {
                    ans = Math.min(ans, getMinCount(ring, key, i, keyIndex+1, dp, ringlen, keylen) + 1 + minDistance(ringIndex, i, ringlen));
                }
            }
            dp[ringIndex][keyIndex] = ans;
        }

        return dp[ringIndex][keyIndex];
    }
    
    public int minDistance(int ringIndex, int i, int ringlen) {
        int d1 = Math.abs(ringIndex-i);
        int d2 = ringlen-d1;

        return Math.min(d1, d2);
    }
}