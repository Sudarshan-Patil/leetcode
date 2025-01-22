class Pair {
    int x;
    int y;
    int val;
    Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[][] highestPeak(int[][] isWater) {
       Queue<Pair> q = new LinkedList<>();
       int row = isWater.length;
       int col = isWater[0].length;

       for (int i=0; i<row; i++) {
        for (int j=0; j<col; j++) {
            if (isWater[i][j] == 1) {
                isWater[i][j] = -1;
                q.offer(new Pair(i, j, 0));
            }
        }
       }
        boolean[][] vis = new boolean[row][col];

       while (!q.isEmpty()) {
        Pair p = q.poll();

        for (int i=0; i<4; i++) {
            int x = p.x + dx[i];
            int y = p.y + dy[i];

            if (x<0 || x>=row || y<0 || y>=col || isWater[x][y] == -1) {
                continue;
            }

            if (!vis[x][y]) {
                vis[x][y] = true;
                isWater[x][y] = 1 + p.val;
                q.offer(new Pair(x, y, isWater[x][y]));
            } 
        }
       }

       for (int i=0; i<row; i++) {
        for (int j=0; j<col; j++) {
            if (isWater[i][j] == -1) {
                isWater[i][j] = 0;
            }
        }
       }

       return isWater;
    }
}