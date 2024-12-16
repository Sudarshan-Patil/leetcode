class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        for (int i=0; i<nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        while (k-- >0) {
            int[] temp = pq.poll();
            temp[0] = temp[0]*multiplier;
            pq.offer(temp);
        }

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            nums[temp[1]] = temp[0];
        }

        return nums;
    }
}