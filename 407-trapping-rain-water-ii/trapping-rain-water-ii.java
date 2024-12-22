class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int height;
        Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        public int compareTo(Pair p) {
            return this.height-p.height;
        }
    }
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[row][col];
        int ans = 0;

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i==0 || j==0 || i == row-1 || j == col-1) {
                    pq.offer(new Pair(i, j, heightMap[i][j]));
                    vis[i][j] = true;
                }
            }
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for (int i=0; i<4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x<0 || x>=row || y<0 || y>=col || vis[x][y]) {
                    continue;
                }

                vis[x][y] = true;
                if (heightMap[x][y] < p.height) {
                    ans += p.height-heightMap[x][y];
                    heightMap[x][y] = p.height;
                }
                pq.offer(new Pair(x, y, heightMap[x][y]));
            }
        }

        return ans;
    }
}