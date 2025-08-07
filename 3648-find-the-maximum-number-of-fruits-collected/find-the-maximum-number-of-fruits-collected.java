class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int[][] maxFruitsDP = new int[fruits.length][fruits[0].length];

        int rows = fruits.length - 1;
        int cols = fruits[0].length - 1;

        maxFruitsDP[0][0] = fruits[0][0];
        maxFruitsDP[0][cols] = fruits[0][cols];
        maxFruitsDP[rows][0] = fruits[rows][0];

        for (int i = 1; i < fruits.length; i++) {
            maxFruitsDP[i][i] = maxFruitsDP[i - 1][i - 1] + fruits[i][i];
        }

        for (int row = 0; row < rows; row++) {
            int nextRow = row + 1;
            for (int col = Math.max(row+1, cols - row); col <= cols  && nextRow < rows; col++) {
                int prevCol = col - 1;
                int nextCol = col + 1;
                if(prevCol >= nextRow) {
                    maxFruitsDP[nextRow][prevCol] = Math.max(maxFruitsDP[nextRow][prevCol], fruits[nextRow][prevCol] + maxFruitsDP[row][col]);
                }
                if(nextCol <= cols) {
                    maxFruitsDP[nextRow][nextCol] = Math.max(maxFruitsDP[nextRow][nextCol], fruits[nextRow][nextCol] + maxFruitsDP[row][col]);
                }
                maxFruitsDP[nextRow][col] = Math.max(maxFruitsDP[nextRow][col], fruits[nextRow][col] + maxFruitsDP[row][col]);
            }
        }

        for (int col = 0; col < cols; col++) {
            int nextCol = col + 1;
            for (int row = Math.max(col+1, rows - col); row <= rows  && nextCol < rows; row++) {
                int prevRow = row - 1;
                int nextRow = row + 1;
                if(prevRow>= nextCol) {
                    maxFruitsDP[prevRow][nextCol] = Math.max(maxFruitsDP[prevRow][nextCol], fruits[prevRow][nextCol] + maxFruitsDP[row][col]);
                }
                if(nextRow <= cols) {
                    maxFruitsDP[nextRow][nextCol] = Math.max(maxFruitsDP[nextRow][nextCol], fruits[nextRow][nextCol] + maxFruitsDP[row][col]);
                }
                maxFruitsDP[row][nextCol] = Math.max(maxFruitsDP[row][nextCol], fruits[row][nextCol] + maxFruitsDP[row][col]);
            }
        }
        return maxFruitsDP[rows - 1][cols] + maxFruitsDP[rows][cols - 1] + maxFruitsDP[rows][cols];
    }
}