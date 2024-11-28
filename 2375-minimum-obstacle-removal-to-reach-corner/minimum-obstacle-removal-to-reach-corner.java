class Pair{
    int x;
    int y;
    int steps;
    Pair(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    public String toString() {
        return this.x + " : " + this.y + " : " + this.steps;
    }
}
class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int minimumObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.steps-b.steps);
        int vis[][] = new int[row][col];

        for (int i=0; i<row; i++) {
            Arrays.fill(vis[i], -1);
        }

        q.offer(new Pair(0, 0, grid[0][0]));
        vis[0][0] = grid[0][0];

        while (!q.isEmpty()) {
            Pair p = q.poll();
            
            if (p.x == row-1 && p.y == col-1) {
                return p.steps;
            }

            for (int i=0; i<4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x<0 || x>=row || y<0 || y>=col) {
                    continue;
                }

                if (vis[x][y] == -1 || vis[x][y] > p.steps + grid[x][y]) {
                    vis[x][y] = p.steps + grid[x][y];
                    q.offer(new Pair(x, y, p.steps+grid[x][y]));
                }
            }
        }

        return -1;
    }
}