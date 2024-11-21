class Pair{ 
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<guards.length; i++) {
            matrix[guards[i][0]][guards[i][1]] = 1;
            q.offer(guards[i]);
        }

        for (int i=0; i<walls.length; i++) {
            matrix[walls[i][0]][walls[i][1]] = 1;
        }
        int count = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i=0; i<4; i++) {
                int x = p[0]+dx[i];
                int y = p[1]+dy[i];

                while (x>=0 && x<m && y>=0 && y<n && matrix[x][y] != 1) {
                    if (matrix[x][y] != 2) {
                        matrix[x][y] = 2;
                        count++;
                    }
                    
                    x = x+dx[i];
                    y = y+dy[i];
                }
            }
        }

        return m*n-guards.length-walls.length-count;
    }
}