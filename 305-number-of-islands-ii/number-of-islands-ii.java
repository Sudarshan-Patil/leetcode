class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] matrix = new int[m][n];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int total = m * n;
        int[] parent = new int[total];
        int[] size = new int[total];
        for (int i=0; i<total; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int k=0; k<positions.length; k++) {
            int i = positions[k][0];
            int j = positions[k][1];

            if (matrix[i][j] == 1) {
                ans.add(count);
                continue;
            }

            matrix[i][j] = 1;
            count++;
            int temp = dfs(i, j, matrix, m, n, parent, size);
            count = Math.abs(temp-count);
            ans.add(count);
        }

        return ans;
    }

    public int dfs(int i, int j, int[][] matrix, int m, int n, int[] parent, int[] size) {
        int step = 0;
        int nodeNo = i * n + j;
        for (int k=0; k<4; k++) {
            int x = i+dx[k];
            int y = j+dy[k];

            if (x<0 || x>=m || y<0 || y>=n || matrix[x][y] == 0) {
                continue;
            }
            
            int adjNodeNo = x * n + y;
            if (findParent(nodeNo, parent)!= findParent(adjNodeNo, parent)) {
                step++;
                unioneBySize(nodeNo, adjNodeNo, parent, size);
            }
        }

        return step;
    }

    public int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }

        int p = findParent(parent[x], parent);
        parent[x] = p;
        return p;
    }

    public void unioneBySize(int i, int j, int[] parent, int[] size) {
        int pi = findParent(i, parent);
        int pj = findParent(j, parent);

        if (pi == pj) {
            return;
        }

        if (size[pi] < size[pj]) {
            size[pj] += size[pi];
            parent[pi] = pj;
        } else {
            size[pi] += size[pj];
            parent[pj] = pi;
        }

        return;
    }
}