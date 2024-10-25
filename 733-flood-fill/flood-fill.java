class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];

        dfs(image, vis, sr, sc, color, n, m, image[sr][sc]);

        return image;
    }

    public void dfs(int[][] image, boolean[][] vis, int sr, int sc, int color, int n, int m, int og) {
        if (sr < 0 || sr >= n || sc < 0 || sc >= m || vis[sr][sc] || image[sr][sc] != og) {
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = color;

        for (int i=0; i<4; i++) {
            dfs(image, vis, sr + dx[i], sc + dy[i], color, n, m, og);
        }

        return;
    }
}