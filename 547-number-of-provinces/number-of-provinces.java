class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (isConnected[i][j] == 1) {
                    int pi = findParent(i, parent);
                    int pj = findParent(j, parent);

                    if (pi == pj) {
                        continue;
                    }

                    if (size[pi] < size[pj]) {
                        parent[pi] = parent[pj];
                        size[pj] += size[pi];
                    } else {
                        parent[pj] = parent[pi];
                        size[pi] += size[pj];
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    public void display(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

    public int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }

        int p = findParent(parent[x], parent);
        parent[x] = p;

        return p;
    }
}