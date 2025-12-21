class Solution {
    public int minDeletionSize(String[] A) {
        int N = A.length;
        int W = A[0].length();
        boolean[] cuts = new boolean[N-1];

        int ans = 0;
        for (int j = 0; j < W; ++j) {
            boolean sorted = true;
            for (int i = 0; i < N-1; ++i) {
                if (!cuts[i] && A[i].charAt(j) > A[i+1].charAt(j)) {
                    ans++;
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                for (int i = 0; i < N-1; ++i) {
                   if (A[i].charAt(j) < A[i+1].charAt(j)) {
                        cuts[i] = true;
                    }
                }
            }
        }

        return ans;
    }
}
