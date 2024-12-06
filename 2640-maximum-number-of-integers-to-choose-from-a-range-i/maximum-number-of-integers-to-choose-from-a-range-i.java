class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0; i<banned.length; i++) {
            hs.add(banned[i]);
        }
        int count = 0;
        for (int num = 1; num<=n; num++) {
            if (hs.contains(num)) {
                continue;
            }

            maxSum -= num;

            if (maxSum < 0) {
                break;
            }

            count++;
        }

        return count;
    }

    public boolean isBanned(int num, int[] banned) {
        int i=0; 
        int j = banned.length-1;

        while(i<=j) {
            int mid = (i+j)/2;

            if (banned[mid] == num) {
                return true;
            }

            if (banned[mid] < num) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }

        return false;
    }
}