class Solution {
    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        Queue < Integer > q = new LinkedList < > ();
        boolean[] vis = new boolean[m * m + 1];
        int steps = 0;
        q.offer(1);
        vis[1] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int num = q.poll();
                if (num == m * m) {
                    return steps;
                }

                for (int i = 1; i < 7; i++) {
                    int temp = num + i;

                    if (temp > m * m) {
                        continue;
                    }

                    if (vis[temp]) {
                        continue;
                    }

                    vis[temp] = true;

                    int[] coordinates = getcoordinates(temp, m);
                    int x = coordinates[0];
                    int y = coordinates[1];
                    if (board[x][y] == -1) {
                        q.offer(temp);
                    } else {
                        q.offer(board[x][y]);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
    public int[] getcoordinates(int num, int m) {
        num -= 1;
        int r = (m - 1) - num / m;
        int c = num % m;
        if (m % 2 == r % 2) {
            c = (m - 1) - c;
        }

        return new int[] {
            r,
            c
        };
    }
}