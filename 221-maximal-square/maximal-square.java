class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        int[][] pf = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                pf[i][j] = matrix[i][j]-'0';
            }
        }
        int len = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pf[i][j] == 1) {
                    if (i==0 || j==0) {
                        len = Math.max(len, 1);
                    } else {
                        pf[i][j] = 1 + Math.min(Math.min(pf[i-1][j], pf[i][j-1]), pf[i-1][j-1]);
                        len = Math.max(len, pf[i][j]);
                    }
                }
            }
        }

        return len * len;
    }
}