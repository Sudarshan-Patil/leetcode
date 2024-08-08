class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows*cols][2];
        int n=0;
        int count = 1;
        int x = rStart;
        int y = cStart;
        int idx = 0;
        ans[idx][0] = x;
        ans[idx][1] = y;
        idx++;
        System.out.print("["+x+":"+y+"]");
        while (n<Math.max(rows, cols)) {
            for (int i=y+1; i<=y+count; i++) {
                if (i<0 || i>=cols || x<0 || x>= rows) {
                    continue;
                }
                System.out.print("["+x+":"+i+"]");
                ans[idx][0] = x;
                ans[idx][1] = i;
                idx++;
            }
            y += count;
            for (int i=x+1; i<=x+count; i++) {
                if (i<0 || i>=rows || y<0 || y>=cols) {
                    continue;
                }
                System.out.print("["+i+":"+y+"]");
                ans[idx][0] = i;
                ans[idx][1] = y;
                idx++;
            }
            x += count;
            count++;

            for (int i=y-1; i>=y-count; i--) {
                if (i<0 || i>=cols || x<0 || x>= rows) {
                    continue;
                }
                System.out.print("["+x+":"+i+"]");
                ans[idx][0] = x;
                ans[idx][1] = i;
                idx++;
            }
            y -= count;
            for (int i=x-1; i>=x-count; i--) {
                if (i<0 || i>=rows || y<0 || y>= cols) {
                    continue;
                }
                System.out.print("["+i+":"+y+"]");
                ans[idx][0] = i;
                ans[idx][1] = y;
                idx++;
            }
            x -= count;
            count++;
            n++;
        }

        return ans;
    }
}