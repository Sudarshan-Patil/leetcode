class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        int count = 0;

        Arrays.sort(temp);

        for (int i=0; i<temp.length; i++) {
            if (temp[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }
}