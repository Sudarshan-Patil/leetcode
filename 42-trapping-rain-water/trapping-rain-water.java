class Solution {
    public int trap(int[] height) {
        Deque<Integer> d = new LinkedList<>();
        int ans = 0;
        int n = height.length;

        int[] pf = new int[n];
        int[] sf = new int[n];

        for (int i=0; i<n; i++) {
            while (!d.isEmpty() && d.peekLast() <= height[i]) {
                d.pollLast();
            }

            pf[i] = d.isEmpty() ? -1 : d.peekFirst();
            d.offerLast(height[i]);
        }

        d = new LinkedList<>();
        for (int i=n-1; i>=0; i--) {
            while (!d.isEmpty() && d.peekLast() <= height[i]) {
                d.pollLast();
            }

            sf[i] = d.isEmpty() ? -1 : d.peekFirst();
            d.offerLast(height[i]);
        }

        for (int i=1; i<n-1; i++) {
            ans +=  Math.max(0, Math.min(sf[i], pf[i]) - height[i]);
        }

        return ans;
    }

    public void display(int[] A) {
        for (int i=0; i<A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        return;
    }
}