class Solution {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a.getKey(), b.getKey())
        );
        int ans = Integer.MAX_VALUE;
        long sum = 0;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            sum += nums[i];

            if (sum >= k) {
                ans = Math.min(ans, i+1);
            }

            while(!pq.isEmpty() && sum-pq.peek().getKey() >= k) {
                ans = Math.min(ans, i-pq.poll().getValue());
            }

            pq.offer(new Pair<>(sum, i));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}