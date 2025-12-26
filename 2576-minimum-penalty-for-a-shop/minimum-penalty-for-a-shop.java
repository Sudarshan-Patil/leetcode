class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] t1 = new int[n];
        int[] t2 = new int[n];
        t1[0] = customers.charAt(0) == 'Y' ? 1 : 0;
        t2[0] = customers.charAt(0) == 'N' ? 1 : 0;
        for (int i=1; i<n; i++) {
            t1[i] = t1[i-1] + (customers.charAt(i) == 'Y' ? 1 : 0);
            t2[i] = t2[i-1] + (customers.charAt(i) == 'N' ? 1 : 0);
        }
        // display(n, t1);
        // display(n, t2);
        int ans = Integer.MAX_VALUE;
        int index = 0;

        for (int i=0; i<n; i++) {
            if (i == 0) {
                if (ans > t1[n-1]) {
                    ans = t1[n-1];
                    index = i;
                }
            } else {
                int temp = (t1[n-1]-t1[i-1]) + t2[i-1];
                if (ans > temp) {
                    ans = temp;
                    index = i;
                }
                // System.out.println(i + " : " + ans + " : " + (t1[n-1]-t1[i-1]) + " : " + t2[i]);
            }
        }

        if (ans > t2[n-1]) {
            return n;
        }

        return index;
    }

    public void display(int n, int[] a) {
        for (int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return;
    }
}