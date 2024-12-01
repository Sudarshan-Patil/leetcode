class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            hs.put(arr[i], i);
        }

        for (int i=0; i<arr.length; i++) {
            if (hs.containsKey(2 * arr[i]) && hs.get(2*arr[i]) != i) {
                return true;
            }
        }

        return false;
    }
}