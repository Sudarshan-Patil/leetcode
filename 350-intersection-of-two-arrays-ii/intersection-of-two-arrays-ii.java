class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(num1);
        Arrays.sort(num2);

        int i=0;
        int j=0;

        while (i<num1.length && j<num2.length) {
            if (num1[i] == num2[j]) {
                arr.add(num1[i]);
                i++;
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = arr.stream().mapToInt(k -> k).toArray();

        return ans;
    }
}