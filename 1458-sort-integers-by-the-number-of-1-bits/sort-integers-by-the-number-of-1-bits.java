class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int t1 = Integer.bitCount(a);
            int t2 = Integer.bitCount(b);

            if (t1 != t2) {
                return t1 - t2;
            }
            return a - b;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}