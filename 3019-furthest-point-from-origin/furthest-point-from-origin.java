class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lcount = 0;
        int rcount = 0;
        int ans = 0;
        int temp=0;

        for (int i=0; i<moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                lcount++;
            } else if (moves.charAt(i) == 'R') {
                rcount++;
            }
        }

        if (lcount >= rcount) {
            temp = -1;
        } else {
            temp = 1;
        }

        for (int i=0; i<moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                ans--;
            } else if (moves.charAt(i) == 'R') {
                ans++;
            } else {
                ans += temp;
            }
        }

        return Math.abs(ans);
    }
}