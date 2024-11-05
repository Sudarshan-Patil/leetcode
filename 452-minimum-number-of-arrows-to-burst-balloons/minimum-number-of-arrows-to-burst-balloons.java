class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        

        int prev=0;
        int count=1;
        for (int i=1; i<points.length; i++) {
            if (points[i][0] > points[prev][1]) {
                count++;
                prev = i;
            }
        }    

        return count;
    }
}