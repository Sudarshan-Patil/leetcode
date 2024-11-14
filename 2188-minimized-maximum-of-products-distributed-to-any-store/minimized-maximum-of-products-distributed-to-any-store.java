class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        if (n<=quantities.length) {
            int ans = 0;
            for (int i=0; i<quantities.length; i++) {
                ans = Math.max(ans, quantities[i]);
            }

            return ans;
        }

        int start = Integer.MAX_VALUE;
        int end = 0;

        for (int i=0; i<quantities.length; i++) {
            start = 1;
            end = Math.max(end, quantities[i]);
        }
        while (start < end) {
            int mid = (start+end)/2;

            if (isValid(mid, n, quantities)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return end;
    }

    public boolean isValid(int mid, int stores, int[] q) {
        int idx = 0;
        int noOfStores = 0;
        
        for (int i=0; i<q.length; i++) {
            noOfStores = q[i]/mid;
            if (q[i]%mid > 0) {
                ++noOfStores;
            }

            idx += noOfStores;

            if (idx > stores) {
                return false;
            }
        }

        return true;
    }
}