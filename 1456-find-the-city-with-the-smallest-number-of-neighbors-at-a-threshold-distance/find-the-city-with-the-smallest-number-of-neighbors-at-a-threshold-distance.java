class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i!=j) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i=0; i<edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int distance = edges[i][2];
            matrix[start][end] = distance;
            matrix[end][start] = distance;
        }

        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(
                            matrix[i][j],
                            matrix[i][k] + matrix[k][j]
                        );
                    }
                }
            }
        }

        

        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                ans = i;
            }
        }

        return ans;
    }

    public void display(int[][] matrix, int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }
}