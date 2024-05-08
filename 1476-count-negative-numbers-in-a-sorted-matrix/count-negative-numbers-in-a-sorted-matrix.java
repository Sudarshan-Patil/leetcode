class Solution {
    public int countNegatives(int[][] grid) {
        int col = grid[0].length-1;
        int row = 0;

        int count = 0;
        while (row<grid.length && col>=0) {
            if (grid[row][col] < 0) {
                col--;
                count+=grid.length-row;
            } else {
                row++;
            }
        }
       
        return count;
    }
}