class Solution {
    boolean[][] vis;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int numIslands(char[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    markLand(i, j, grid);
                }
            }
        }
        return count;
    }

    public void markLand(int i, int j, char[][] grid) {
        if (i>=grid.length || j>=grid[0].length || i<0 || j<0 || vis[i][j] == true || grid[i][j] == '0') {
            return;
        }

        vis[i][j] = true;
        for (int k=0; k<4; k++) {
            markLand(i+dx[k], j+dy[k], grid);
        }

        return;
    }
}