class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (((long) m*k) > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i=0; i<bloomDay.length; i++)  {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low+high)/2;

            if (isValid(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] b, int m, int k, int mid) {
        for (int i=0; i<b.length; i++) {
            int count = 0;
            while (i<b.length && count < k && b[i] <= mid) {
                i++;
                count++;
            }

            if (count == k) {
                m--;
                i--;
            }

            if (m == 0) {
                return true;
            }
        }

        return false;
    }
}