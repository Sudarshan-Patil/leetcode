class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(n);
        while(n>1) {
            int temp = n;
            n = 0;
            while(temp!=0) {
                n += (temp%10) * (temp%10);
                temp /= 10;
            }

            if (hs.contains(n)) {
                return false;
            } else {
                hs.add(n);
            }
        }

        return n==1;
    }
}