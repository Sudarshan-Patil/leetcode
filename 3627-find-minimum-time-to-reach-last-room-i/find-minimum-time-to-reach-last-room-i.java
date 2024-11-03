class Node {
    int x;
    int y;
    int step;
    Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.step));
        boolean[][] vis = new boolean[n][m];

        int[][] time = new int[n][m];
        for (int[] row : time) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        q.offer(new Node(0, 0, 0));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == n-1 && node.y == m-1) {
                return node.step;
            }

            for (int i=0; i<4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if (x<0 || x>=n || y<0 || y>=m || vis[x][y]) {
                    continue;
                }

                vis[x][y] = true;
                int waitTime = Math.max(moveTime[x][y] - node.step, 0);
                int newTime = waitTime + 1 + node.step;

                if (newTime < time[x][y]) {
                    time[x][y] = newTime;
                    q.offer(new Node(x, y, newTime));
                }
            }
        }

        return -1;
    }
}