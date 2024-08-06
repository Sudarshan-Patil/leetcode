class Solution {
    public int findCenter(int[][] edges) {
        int s = edges[0][0];
        int e = edges[0][1];

        if (edges[1][0] == s || edges[1][1] == s) {
            return s;
        } else {
            return e;
        }
    }
}