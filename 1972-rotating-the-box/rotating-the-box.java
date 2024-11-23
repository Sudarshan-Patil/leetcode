class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box[0].length;
        int n = box.length;
        int row = n-1;

        char[][] ans = new char[m][n];
        for (int i=0; i<m; i++) {
            Arrays.fill(ans[i], '.');
        }
        for (int i=0; i<n; i++) {
            int prev = -1;
            for (int j=m-1; j>=0; j--) {
                if (box[i][j] == '*') {
                    ans[j][row-i] = '*';
                    prev = j-1;
                } else if (box[i][j] == '#') {
                    if (prev == -1) {
                        ans[j][row-i] = '#';
                        prev = j-1;
                    } else {
                        ans[prev][row-i] = '#';
                        prev = prev-1;
                    }
                } else {
                    if (prev == -1) {
                        prev = j;
                    }
                }
            }
        }

        return ans;
    }
}