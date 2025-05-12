class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> hs = new HashSet<>();
        int n = digits.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (digits[k]%2 == 0) {
                        if (digits[i] > 0) {
                            hs.add(digits[i]*100 + digits[j]*10 +digits[k]);
                        }
                        if (digits[j] > 0) {
                            hs.add(digits[j]*100 + digits[i]*10 +digits[k]);
                        }
                    }
                    if (digits[j]%2 == 0) {
                        if (digits[i] > 0) {
                            hs.add(digits[i]*100 + digits[k]*10 +digits[j]);
                        }
                        if (digits[k] > 0) {
                            hs.add(digits[k]*100 + digits[i]*10 +digits[j]);
                        }
                    }
                    if (digits[i]%2 == 0) {
                        if (digits[j] > 0) {
                            hs.add(digits[j]*100 + digits[k]*10 +digits[i]);
                        }
                        if (digits[k] > 0) {
                            hs.add(digits[k]*100 + digits[j]*10 +digits[i]);
                        }
                    }
                }
            }
        }

        int s = hs.size();

        int[] ans = new int[s];
        int i = 0;
        for (int key:hs) {
            ans[i++] = key;
        }
        Arrays.sort(ans);
        return ans;
    }
}