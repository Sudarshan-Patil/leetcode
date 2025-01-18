class Pair{
    int cost;
    int x;
    int y;
    Pair(int cost, int x, int y) {
        this.cost = cost;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost-b.cost);
        int[][] costs = new int[m][n];
        for (int i=0; i<m; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        pq.offer(new Pair(0, 0, 0));
        costs[0][0] = 0;
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (costs[p.x][p.y] != p.cost) {
                continue;
            }

            for (int i=0; i<4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x<0 || x>=m || y<0 || y>=n) {
                    continue;
                }

                int newCost = p.cost + ((grid[p.x][p.y] == i+1) ? 0 : 1);
                if (newCost < costs[x][y]) {
                    costs[x][y] = newCost;
                    pq.offer(new Pair(newCost, x, y));
                }

            }
        }

        return costs[m-1][n-1];
    }
}