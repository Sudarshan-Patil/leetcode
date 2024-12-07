class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1]-b[1];
                } else {
                    return a[0]-b[0];
                }
            }
        });

        int[] t = new int[2];
        t[0] = intervals[0][0];
        t[1] = intervals[0][1];
        
        for (int i=1; i<intervals.length; i++) {
            if (t[1] < intervals[i][0]) {
                ans.add(t);
                t = intervals[i];
            } else {
                t[1] = Math.max(t[1], intervals[i][1]);
            }
        }

        ans.add(t);

        int[][] res = new int[ans.size()][2];

        for (int i=0; i<ans.size(); i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }

        return res;
    }
}