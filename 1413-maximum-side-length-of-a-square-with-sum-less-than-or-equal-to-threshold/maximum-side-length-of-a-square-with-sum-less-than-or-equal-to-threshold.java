class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i=1; i<n; i++) {
            mat[i][0] += mat[i-1][0];
        }

        for (int j=1; j<m; j++) {
            mat[0][j] += mat[0][j-1];
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                mat[i][j] += mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
            }
        }

        int low = 1;
        int high = Math.min(n, m);
        int ans = 0;
        while (low <= high) {
            int mid = (low + high)/2;

            if (valid(mid, mat, threshold)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }

    public boolean valid(int mid, int[][] mat, int t) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i=mid-1; i<n; i++) {
            for (int j=mid-1; j<m; j++) {
                int sum = mat[i][j];

                if (i-mid>=0) {
                    sum -= mat[i-mid][j];
                }

                if (j-mid>=0) {
                    sum -= mat[i][j-mid];
                }

                if (i-mid >=0 && j-mid>=0) {
                    sum += mat[i-mid][j-mid];
                }

                if (sum <=t) {
                    return true;
                }
            }
        }

        return false;
    }
}