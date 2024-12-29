class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int row = grid.length;
        int col = grid[0].length;
        int total = row * col;
        int[] parent = new int[total];
        int[] size = new int[total];
        // displayMatrix(grid);
        for (int i=0; i<total; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, parent, size, row, col);
                }
            }
        }
        if (size[0] == total) {
            return total;
        }
        // display(parent);
        // display(size);

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 0) {
                    int step = 0;
                    int node = i * col + j;
                    HashSet<Integer> hs = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x<0 || x>=row || y<0 || y>=col || grid[x][y] == 0) {
                            continue;
                        }

                        int adjNode = x * col + y;
                        int p = findParent(adjNode, parent);
                        if (!hs.contains(p)) {
                            hs.add(p);
                            step += size[p];
                        }
                    }
                    ans = Math.max(ans, step + 1);
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

    public void dfs(int i, int j, int[][] grid, int[] parent, int[] size, int row, int col) {
        int node = i * col + j;
        for (int k=0; k<4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x<0 || x>=row || y<0 || y>=col || grid[x][y] == 0) {
                continue;
            }

            int adjNode = x * col + y;
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

    public void displayMatrix(int[][] grid) {
        int n = grid.length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return;
    }
}