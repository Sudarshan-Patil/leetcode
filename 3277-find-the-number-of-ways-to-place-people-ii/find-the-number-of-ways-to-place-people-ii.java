class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points , (a , b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int cntPairs = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            int aliceY = points[i][1];
            int last = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int bobY = points[j][1];
                if (aliceY >= bobY && bobY > last) {
                    last = bobY;
                    cntPairs++;
                }
            }
        }
        return cntPairs;
    }
}