class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            int sum = 0;
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] != '0') {
                    sum += matrix[i][j]-'0';
                } else {
                    sum = 0;
                }
                ans[i][j] = sum;
            }
        }

        int res = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int k=i;
                int min = ans[k][j];
                while (k>=0 && ans[k][j] > 0) {
                    min = Math.min(min, ans[k][j]);
                    res = Math.max(res, min * (i-k+1));
                    k--;
                }
            }
        }

        return res;
    }
}