class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int e = m+n-1;

        while (p1>=0 && p2>=0) {
            if (num1[p1] > num2[p2]) {
                num1[e--] = num1[p1--];
            } else {
                num1[e--] = num2[p2--];
            }
        }

        while (p2>=0) {
            num1[e--] = num2[p2--];
        }

        return;
    }
}