class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (arr.length != target.length) {
            return false;
        }

        int[] f = new int[1001];

        for (int i=0; i<target.length; i++) {
            f[target[i]]++;
        }

        for (int i=0; i<arr.length; i++) {
            f[arr[i]]--;
            if (f[target[i]] < 0) {
                return false;
            }
        }        

        for (int i=0; i<1001; i++) {
            if (f[i] != 0) {
                return false;
            }
        }

        return true;
    }
}