class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] range = new int[n+1][2];

        for (int i=0; i<ranges.length; i++) {
            range[i][0] = Math.max(0, i-ranges[i]);
            range[i][1] = Math.min(n, i+ranges[i]);
        }

        Arrays.sort(range, (a,b) -> {
            return a[0]-b[0];
        });

        int jump = 0;
        int currentEnd = 0;
        int i = 0;
        int farthestEnd = 0;

        while (currentEnd < n) {
            jump++;
            farthestEnd = 0;
            while (i<range.length && range[i][0] <= currentEnd) {
                farthestEnd = Math.max(farthestEnd, range[i][1]);
                i++;
            }

            if (farthestEnd <= currentEnd) {
                return -1;
            }

            currentEnd = farthestEnd;
        }

        return jump;
    }
}