class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr1 = new int[n+1];
        int[] arr2 = new int[n+1];

        for (int i=0; i<trust.length; i++) {
            arr1[trust[i][0]]++;
            arr2[trust[i][1]]++;
        }
        
        for (int i=1; i<=n; i++) {
            if (arr2[i] == n-1 && arr1[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}