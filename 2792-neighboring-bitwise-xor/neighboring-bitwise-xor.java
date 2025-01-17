class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        return check(0, 0, 0, derived.length, derived) | check(1, 0, 1, derived.length, derived);
    }

    public boolean check(int i, int index, int first, int n, int[] derived) {
        if (index == n-1) {
            if ((i^first) == derived[index]) {
                return true;
            } else {
                return false;
            }
        }

        if ((i^0) == derived[index] && check(0, index+1, first, n, derived)) {
            return true;
        } else if ((i^1) == derived[index] && check(1, index+1, first, n, derived)) {
            return true;
        } else {
            return false;
        }
    }
}