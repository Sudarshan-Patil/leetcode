class CustomStack {
    int capacity = 0;
    Stack<Integer> st = new Stack<>();
    public CustomStack(int maxSize) {
        this.capacity = maxSize;
    }
    
    public void push(int x) {
        if (st.size() < capacity) {
            st.push(x);
        }
        return;
    }
    
    public int pop() {
        if (!st.isEmpty()) {
            return st.pop();
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        while (!temp.isEmpty()) {
            if (k > 0) {
                k--;
                st.push(temp.pop() + val);
            } else {
                st.push(temp.pop());
            }
        }
        return;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */