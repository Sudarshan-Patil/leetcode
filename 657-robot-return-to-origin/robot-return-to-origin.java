class Solution {
    public boolean judgeCircle(String moves) {
        int r=0;
        int c=0;
        for (int i=0; i<moves.length(); i++) {
            if (moves.charAt(i) == 'R') {
                c++;
            } else if (moves.charAt(i) == 'L') {
                c--;
            } else if (moves.charAt(i) == 'U') {
                r--;
            } else {
                r++;
            }
        }

        if (r==0 && c==0) {
            return true;
        }

        return false;
    }
}