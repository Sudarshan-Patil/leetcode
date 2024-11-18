class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k==0) {
            return new int[code.length];
        }
        int n = code.length;
        int[] ans = new int[n];
        if (k>0) {
            for (int i=0; i<code.length; i++) {
                int j = i;
                int sum = 0;
                for (int a=1; a<=k; a++) {
                    j = (i+a)%n;
                    sum += code[j];
                }
                ans[i] = sum;
            }
        } else {
            for (int i=n-1; i>=0; i--) {
                int j = i;
                int sum = 0;
                for (int a=1; a<=Math.abs(k); a++) {
                    j = (i-a)%n;
                    if (j<0) {
                        j = n+j;
                    }
                    System.out.println(i + " : " + j);
                    sum += code[j];
                }
                ans[i] = sum;
            }
        }
        return ans;
    }
}