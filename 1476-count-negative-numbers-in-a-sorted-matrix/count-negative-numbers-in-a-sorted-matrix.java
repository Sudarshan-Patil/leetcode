class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int n = 0;
        int m = col-1;

        int count = 0;
        while (n<row && m >= 0) {
            if (grid[n][m] >= 0) {
                n++;
            } else {
                count += row-n;
                m--;
            }
        }

        return count;
    }
}