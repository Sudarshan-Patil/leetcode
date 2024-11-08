class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (min.size() > max.size()) {
            min.offer(num);
            max.offer(min.poll());
        } else {
            max.offer(num);
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return (double)(min.peek()+max.peek())/2;
        } else {
            return (double)min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */