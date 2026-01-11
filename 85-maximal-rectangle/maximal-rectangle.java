class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int ans = 0;

        int[][] data = new int[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == '0') {
                    data[i][j] = 0;
                } else {
                    if (j>0) {
                        data[i][j] = 1 + data[i][j-1];
                    } else {
                        data[i][j] = 1;
                    }
                }
            }
        }

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int k = data[i][j];
                int a = i;
                while (a>=0 && data[a][j] > 0) {
                    k = Math.min(k, data[a][j]);
                    ans = Math.max(ans, (i-a+1)*k);
                    a--;
                }
// System.out.println(a);
                
            }
        }

        // display(data);

        return ans;
    }

    public void display(int[][] m) {
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }
}