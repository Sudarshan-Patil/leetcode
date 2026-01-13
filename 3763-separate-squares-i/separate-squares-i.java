class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0;
        double maxy = 0;

        for (int[] sq:squares) {
            int y = sq[1];
            int l = sq[2];

            total += (double)l * l;
            maxy = Math.max(maxy, (double)(y+l));
        }

        double low = 0;
        double high = maxy;
        double eps = 1e-5;
        while (Math.abs(high-low) > eps) {
            double mid = (high+low)/2;

            if (check(mid, squares, total)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    public boolean check(double mid, int[][] squares, double total) {
        double area = 0;

        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];

            if (y < mid) {
                area += (double)l * Math.min((double)l, mid-y);
            }
        }

        return area >= total/2;
    }
}