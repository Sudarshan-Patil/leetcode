class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        HashMap<Integer, int[]> hm = new HashMap<>();

        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                hm.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i=0; i<arr.length; i++) {
            int[] a = hm.get(arr[i]);

            putInMap(rowMap, a[0]);
            putInMap(colMap, a[1]);

            // System.out.println(rowMap);
            // System.out.println(colMap);

            if (rowMap.get(a[0]) == col || colMap.get(a[1]) == row) {
                return i;
            }
        }

        return -1;
    }

    public void putInMap(HashMap<Integer, Integer> hm, int num) {
        if (!hm.containsKey(num)) {
            hm.put(num, 1);
        } else {
            hm.put(num, hm.get(num)+1);
        }

        return;
    }
}