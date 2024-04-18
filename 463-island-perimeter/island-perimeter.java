class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int islandPerimeter(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return getCount(grid, i, j, vis);
                }
            }
        }

        return -1;
    }

    public int getCount(int[][] A, int i, int j, boolean[][] vis) {
        if (i>=A.length || j>=A[0].length || i<0 || j<0 || A[i][j] == 0) {
            return 1;
        }

        if (vis[i][j] == true) {
            return 0;
        }
        vis[i][j] = true;
        int sum = 0;
        for (int k=0; k<4; k++) {
            sum += getCount(A, i+dx[k], j+dy[k], vis);
        }

        return sum;
    }
}