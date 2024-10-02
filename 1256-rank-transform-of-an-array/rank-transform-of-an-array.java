class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();

        Arrays.sort(temp);

        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 1;
        for (int i=0; i<temp.length; i++) {
            if (!hm.containsKey(temp[i])) {
                hm.put(temp[i], idx++);
            }
        }

        for (int i=0; i<arr.length; i++) {
            arr[i] = hm.get(arr[i]);
        }

        return arr;
    }
}