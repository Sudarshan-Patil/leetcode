class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            return a[0]-b[0];
        });

        for (int i=1; i<items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i-1][1]);
        }

        int n = items.length;
        int[] ans = new int[queries.length];

        for (int i=0; i<queries.length; i++) {
            int start = 0;
            int end = n-1;
            int target = queries[i];
            int temp = 0;

            while (start <= end) {
                int mid = (start+end)/2;

                if (items[mid][0] > target) {
                    end = mid-1;
                } else {
                    temp = Math.max(temp, items[mid][1]);
                    start = mid+1;
                }
            }

            ans[i] = temp;
        }

        return ans;
    }
}