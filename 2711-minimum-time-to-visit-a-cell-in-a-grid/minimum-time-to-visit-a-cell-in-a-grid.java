class Pair{
    int x;
    int y;
    int steps;
    Pair(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> (a.steps-b.steps));
        boolean[][] vis = new boolean[row][col];

        q.offer(new Pair(0, 0, grid[0][0]));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == row-1 && p.y == col-1) {
                return p.steps;
            }

            if (vis[p.x][p.y]) {
                continue;
            }

            vis[p.x][p.y] = true;

            for (int i=0; i<4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x<0 || x>=row || y<0 || y>=col || vis[x][y]) {
                    continue;
                }

                int waitTime = (grid[x][y]-p.steps)%2 == 0 ? 1 : 0;
                int nextTime = Math.max(p.steps+1, grid[x][y]+waitTime);

                q.offer(new Pair(x, y, nextTime));
            }
        }

        return -1;
    }
}