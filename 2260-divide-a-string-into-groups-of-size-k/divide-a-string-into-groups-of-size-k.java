class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = n/k + (n%k == 0 ? 0 : 1);
        String[] ans = new String[size];
        int idx =0;
        int i=0;
        while(i<=s.length()-k) {
            ans[idx++] = s.substring(i, i+k);
            i+=k;
        }

        if (i<s.length()) {
            ans[idx] = s.substring(i, s.length());
            while (ans[idx].length() < k) {
                ans[idx] += fill;
            }
        }

        return ans;
    }
}