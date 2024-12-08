class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int len = events.length;
        int[][] dp = new int[len][2];
        for (int i=0; i<len; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMax(events, 0, len, 0, dp);
    }

    public int getMax(int[][] events, int idx, int len, int count, int[][] dp) {
        if (count == 2 || idx >= len) {
            return 0;
        }

        if (dp[idx][count] != -1) {
            return dp[idx][count];
        }

        int excludes = getMax(events, idx+1, len, count, dp);

        int left = idx+1;
        int right = len-1;

        while (left < right) {
            int mid = (left+right)/2;

            if (events[mid][0] > events[idx][1]) {
                right = mid;
            } else {
                left = mid+1;
            }
        };
        
        int includes = events[idx][2] + (left < len && events[left][0] > events[idx][1] ? getMax(events, left, len, count+1, dp) : 0);

        dp[idx][count] = Math.max(includes, excludes);

        return dp[idx][count];
    }
}