class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        int total = n * n;
        int[] parent = new int[total];
        int[] size = new int[total];
        for (int i=0; i<total; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, parent, size, n);
                }                
            }
        }

        if (size[0] == total) {
            return size[0];
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    int count = 0;
                    HashSet<Integer> hs = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x<0 || x>=n || y<0 || y>=n || grid[x][y] == 0) {
                            continue;
                        }

                        int adjNode = x * n + y;
                        int ap = findParent(adjNode, parent);
                        if (!hs.contains(ap)) {
                            hs.add(ap);
                            count += size[ap];
                        }
                    }

                    ans = Math.max(ans, count+1);
                }                
            }
        }

        return ans;
    }

    public void display(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

    public void dfs(int i, int j, int[][] grid, int[] parent, int[] size, int n) {
        int node = i * n + j;
        for (int k=0; k<4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x<0 || x>=n || y<0 || y>=n || grid[x][y] == 0) {
                continue;
            }

            int adjNode = x * n + y;
            unionBySize(node, adjNode, parent, size);
        }
    }

    public int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }

        int p = findParent(parent[x], parent);
        parent[x] = p;

        return p;
    }

    public void unionBySize(int i, int j, int[] parent, int[] size) {
        int pi = findParent(i, parent);
        int pj = findParent(j, parent);

        if (pi == pj) {
            return;
        }

        if (size[pi] < size[pj]) {
            parent[pi] = pj;
            size[pj] += size[pi];
        } else {
            parent[pj] = pi;
            size[pi] += size[pj];
        }

        return;
    }
}