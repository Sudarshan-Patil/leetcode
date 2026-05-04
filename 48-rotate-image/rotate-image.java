class Solution {
    public void rotate(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=i+1; j<matrix[0].length; j++) {                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;                
            }
        }

        int s = 0;
        int e=matrix[0].length-1;
        for (int i=0; i<matrix.length; i++) {
            while (s<e) {
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
                s++;
                e--;
            }
            s=0;
            e=matrix[0].length-1;
        }
        return;
    }
}