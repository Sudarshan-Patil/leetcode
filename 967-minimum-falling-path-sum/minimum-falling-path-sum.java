class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int a = Integer.MAX_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        for (int i=0; i<row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i=0; i<col; i++) {
            a = Math.min(a, getMin(0, i, matrix, dp));
        }

        return a;
    }

    public int getMin(int row, int col, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= matrix.length) {
            return Integer.MAX_VALUE;
        }

        if (row == matrix.length-1) {
            return matrix[row][col];
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int a = getMin(row+1, col-1, matrix, dp);
        int b = getMin(row+1, col, matrix, dp);
        int c = getMin(row+1, col+1, matrix, dp);
        dp[row][col] = Math.min(a, Math.min(b, c)) + matrix[row][col];

        return dp[row][col];
    }
}