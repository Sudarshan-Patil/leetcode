class Solution {
    public int getCommon(int[] num1, int[] num2) {
        int i = 0;
        int j = 0;

        while (i<num1.length && j<num2.length) {
            if (num1[i] == num2[j]) {
                return num1[i];
            }

            if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}