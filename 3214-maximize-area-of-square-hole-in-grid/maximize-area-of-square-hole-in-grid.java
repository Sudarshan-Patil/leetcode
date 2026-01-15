class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hcount = 1;
        int vcount = 1;

        int hmax = 1;
        int vmax = 1;

        for (int i=1; i<hBars.length; i++) {
            if (hBars[i] == hBars[i-1]+1) {
                hcount++;
            } else {
                hcount = 1;
            }

            hmax = Math.max(hmax, hcount);
        }

        for (int i=1; i<vBars.length; i++) {
            if (vBars[i] == vBars[i-1]+1) {
                vcount++;
            } else {
                vcount = 1;
            }

            vmax = Math.max(vmax, vcount);
        }

        int side = Math.min(hmax, vmax)+1;
        return side*side;
    }
}