class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int ans = 0;
        int temp=0;

        for (int i=0; i<moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                temp--;
            } else if (moves.charAt(i) == 'R') {
                temp++;
            }
        }

        if (temp <= 0) {
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