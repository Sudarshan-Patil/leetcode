class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        
        for (int i=0; i<queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            ans[x1][y1] += 1;
            if (x2 < n-1) {
                ans[x2+1][y1] -= 1;
            }

            if (y2 < n-1) {
                ans[x1][y2+1] -= 1;
            }

            if (x2 < n-1 && y2 < n-1) {
                ans[x2+1][y2+1] += 1;
            }
        }

        for (int i=1; i<n; i++) {
            ans[0][i] = ans[0][i-1] + ans[0][i];
        }

        for (int i=1; i<n; i++) {
            ans[i][0] = ans[i-1][0] + ans[i][0];
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<n; j++) {
                ans[i][j] = ans[i][j] - ans[i-1][j-1] + ans[i][j-1] + ans[i-1][j];
            }
        }

        
        return ans;
    }

    public void display(int [][] ans, int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }
}