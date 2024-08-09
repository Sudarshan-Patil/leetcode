class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (n < 3 || m < 3) {
            return 0;
        }

        int count = 0;
        for (int i=0; i+2<n; i++) {
            for (int j=0; j+2<m; j++) {
                if (unique(grid, i, j) && valid(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean unique(int[][] grid, int x, int y) {
        int[] arr = new int[10];

        for (int i=x; i<x+3; i++) {
            for (int j=y; j<y+3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || arr[grid[i][j]] > 0) {
                    return false;
                } else {
                    arr[grid[i][j]] = 1;
                }
            }
        }

        return true;
    }

    public boolean valid(int[][] grid, int i, int j) {
        int n = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        if (
            row2(grid, i, j) == n &&
            row3(grid, i, j) == n &&
            col1(grid, i, j) == n &&
            col2(grid, i, j) == n &&
            col3(grid, i, j) == n &&
            dig1(grid, i, j) == n &&
            dig2(grid, i, j) == n
        ) {
            return true;
        }
        return false;
    }

    public int row2(int[][] grid, int i, int j) {
        return grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
    }

    public int row3(int[][] grid, int i, int j) {
        return grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
    }

    public int col1(int[][] grid, int i, int j) {
        return grid[i][j]+grid[i+1][j]+grid[i+2][j];
    }

    public int col2(int[][] grid, int i, int j) {
        return grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
    }

    public int col3(int[][] grid, int i, int j) {
        return grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
    }

    public int dig1(int[][] grid, int i, int j) {
        return grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
    }

    public int dig2(int[][] grid, int i, int j) {
        return grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];
    }
}