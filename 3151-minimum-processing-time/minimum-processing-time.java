class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int n = tasks.size();
        int p = processorTime.size();
        int i=0; 
        int j=0;
        int ans = 0;
        while (i<n) {
            ans = Math.max(ans, tasks.get(i++) + processorTime.get(j));
            ans = Math.max(ans, tasks.get(i++) + processorTime.get(j));
            ans = Math.max(ans, tasks.get(i++) + processorTime.get(j));
            ans = Math.max(ans, tasks.get(i++) + processorTime.get(j));
            j++;
        }

        return ans;
    }
}