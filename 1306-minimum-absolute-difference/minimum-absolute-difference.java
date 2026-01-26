class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int len = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-1; i++) {
            int temp = arr[i+1]-arr[i];
            if (temp < len) {
                len = temp;
                ans = new ArrayList<>();
                List<Integer> t = Arrays.asList(arr[i], arr[i+1]);
                ans.add(new ArrayList<Integer>(t));
            } else if (temp == len) {
                List<Integer> t = Arrays.asList(arr[i], arr[i+1]);
                ans.add(new ArrayList<Integer>(t));
            }
        }

        return ans;
    }
}