class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] min = new int[matrix.length][matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            min[0][j] = matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = Integer.MAX_VALUE;
                for (int k=j-1; k<=j+1; k++) {
                    if (k<0 || k>=matrix[0].length) {
                        continue;
                    }
                    temp = Math.min(temp, min[i-1][k] + matrix[i][j]);
                }
                min[i][j] = temp;
            }
        }

        int lastRow = min.length - 1;
        int ans = min[lastRow][0];
        for (int i=1; i<matrix[0].length; i++) {
            ans = Math.min(ans, min[lastRow][i]);
        }

        return ans;
    }
}