class KthLargest {
    PriorityQueue<Integer> pq;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int i=0; i<nums.length; i++) { 
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() == k) {
            return pq.peek();
        } else if (pq.size() > k) {
            pq.poll();
            return pq.peek();
        } else {
            return -1;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */