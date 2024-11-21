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
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<guards.length; i++) {
            matrix[guards[i][0]][guards[i][1]] = 1;
            q.offer(new Pair(guards[i][0],guards[i][1]));
        }

        for (int i=0; i<walls.length; i++) {
            matrix[walls[i][0]][walls[i][1]] = -1;
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i=0; i<4; i++) {
                int x = p.x+dx[i];
                int y = p.y+dy[i];

                while (x>=0 && x<m && y>=0 && y<n && matrix[x][y] != -1 && matrix[x][y] != 1) {
                    matrix[x][y] = 2;
                    x = x+dx[i];
                    y = y+dy[i];
                }
            }
        }
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] == 0) {
                    count++;
                }
            }
            System.out.println();
        }

        return count;
    }
}