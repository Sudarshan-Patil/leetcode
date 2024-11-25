class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int count = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                ans += Math.abs(temp);
                if (temp < 0) {
                    count++;
                }
                minValue = Math.min(minValue, Math.abs(temp));
            }
        }

        if (count%2 != 0) {
            ans -= 2 * minValue;
        }
        
        return ans;
    }
}