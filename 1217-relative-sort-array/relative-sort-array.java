class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] a1 = new int[1001];
        
        for (int i=0; i<arr1.length; i++) {
            a1[arr1[i]]++;
        }

        int j=0;
        for (int i=0; i<arr2.length; i++) {
            if (a1[arr2[i]] > 0) {
                while (a1[arr2[i]] > 0) {
                    arr1[j++] = arr2[i];
                    a1[arr2[i]]--;
                }
            }
        }

        for (int i=0; i<1001; i++) {
            if (a1[i] > 0) {
                while (a1[i] > 0) {
                    arr1[j++] = i;
                    a1[i]--;
                }
            }
        }

        return arr1;
    }
}