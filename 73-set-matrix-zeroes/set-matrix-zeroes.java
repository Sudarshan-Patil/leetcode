class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstColumnZero = false;
        boolean isFirstRowZero = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // when working on (i, j), (i, 0 has already been worked on)
                    if (j == 0) {
                        isFirstColumnZero = true;
                    } else {
                        matrix[0][j] = 0;
                    }

                    if (i==0) {
                        isFirstRowZero = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isFirstColumnZero) {
            for (int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }

        return;        
    }
}