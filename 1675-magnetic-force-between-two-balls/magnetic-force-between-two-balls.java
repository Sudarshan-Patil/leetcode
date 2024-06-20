class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        long s = 1;
        long e = position[0];

        for (int i=1; i<position.length; i++) {
            e = Math.max(e, position[i]);
        }
        long ans = 0;

        while (s<=e) {
            long mid = s+(e-s)/2;

            if (valid(position, mid, m)) {
                ans = mid;
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        return (int)ans;
    }

    public boolean valid(int[] p, long mid, int k) {
        int count = 1;
        int pos = 0;
        int j = 1;
        while (j<p.length) {
            if (p[j]-p[pos] >= mid) {
                pos = j;
                count++;
                if (count == k) {
                    return true;
                }
            }
            j++;
        }

        return false;
    }
}