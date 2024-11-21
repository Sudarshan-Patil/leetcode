class Solution {
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        int ringLength = ring.length();
        int keyLength = key.length();
        dp = new int[ringLength][keyLength];
        for (int i=0; i<ringLength; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(ring, key, 0, 0);
    }

    public int dfs(String ring, String key, int ringIndex, int keyIndex) {
        if (keyIndex == key.length()) {
            return 0;
        }

        if (dp[ringIndex][keyIndex] != -1) {
            return dp[ringIndex][keyIndex];
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i=0; i<ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int steps = dfs(ring, key, i, keyIndex+1) + 1 + minDistance(ringIndex, i, ring.length());
                minSteps = Math.min(minSteps, steps);
            }
        }

        dp[ringIndex][keyIndex] = minSteps;

        return dp[ringIndex][keyIndex];
    }

    public int minDistance(int ringIndex, int i, int ringLength) {
        int clockDistance = Math.abs(ringIndex-i);
        int antiClockDistance = ringLength-clockDistance;

        return Math.min(clockDistance, antiClockDistance);
    }
}