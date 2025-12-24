class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        reverse(capacity);
        int ans = 0;
        for (int i=0; i<apple.length; i++) {
            int t = apple[i];
            for (int j=0; j<capacity.length; j++) {
                if (t <= capacity[j]) {
                    capacity[j] -= t;
                    ans = Math.max(ans, j+1);
                    break;
                } else {
                    t -= capacity[j];
                    capacity[j] = 0;
                }
            }
        }

        return ans;
    }

    public void reverse(int[] a) {
        int i = 0;
        int j = a.length-1;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return;
    }
}