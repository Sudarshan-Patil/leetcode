class Pair implements Comparable<Pair>{
    int x;
    int y;
    int steps;
    Pair(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    public int compareTo(Pair p) {
        return this.steps-p.steps;
    }
}
class Solution {
    public int minimumEffortPath(int[][] grid) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int row = grid.length;
        int col = grid[0].length;

        int[][] vis = new int[row][col];

        for (int i=0; i<row; i++) {
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(0, 0, 0));
        vis[0][0] = 0;

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

                int diff = Math.max(vis[p.x][p.y], Math.abs(grid[x][y]-grid[p.x][p.y]));
                if (diff < vis[x][y]) {
                    vis[x][y] = diff;
                    q.offer(new Pair(x, y, diff));
                }
            }
        }

        return -1;
    }
}