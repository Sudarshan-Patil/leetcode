class Solution {
    public int matrixScore(int[][] grid) {
        for (int i=0; i<grid.length; i++) {
            if (grid[i][0] == 0) {
                toggleX(grid, i);
            }
        }
        int n = grid.length;
        for (int j=0; j<grid[0].length; j++) {
            int count = 0;
            for (int i=0; i<grid.length; i++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
            if (count > n/2) {
                toggleY(grid, j);
            }
        }
        int ans = 0;
        for (int i=0; i<grid.length; i++) {
            int mul = 1;
            int sum = 0;
            for (int j=grid[0].length-1; j>=0; j--) {
                sum += grid[i][j]*mul;
                mul *= 2;
            }
            ans += sum;
        }

        return ans;
    }

    public void toggleX(int[][] grid, int i) {
        for (int j=0; j<grid[0].length; j++) {
            grid[i][j] = 1-grid[i][j];
        }
        return;
    }

    public void toggleY(int[][] grid, int j) {
        for (int i=0; i<grid.length; i++) {
            grid[i][j] = 1-grid[i][j];
        }
        return;
    }
}