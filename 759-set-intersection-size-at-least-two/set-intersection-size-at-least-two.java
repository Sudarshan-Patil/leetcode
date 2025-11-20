class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int ans = 0;
        int a = -1, b = -1;

        for (int[] it : intervals) {
            int l = it[0], r = it[1];
            boolean hasa = a >= l && a <= r;
            boolean hasb = b >= l && b <= r;

            if (hasa && hasb) {
                continue;
            } else if (hasb) {
                a = b;
                b = r;
                ans += 1;
            } else {
                a = r-1;
                b = r;
                ans += 2;
            }

        }

        return ans;
    }
}