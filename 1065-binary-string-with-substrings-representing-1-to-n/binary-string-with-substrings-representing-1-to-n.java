class Solution {
    public boolean queryString(String s, int n) {
        for(int i=1;i<=n;i++){
            if(!s.contains(getBinary(i))){
                return false;
            }
        }
        return true;
    }

    public String getBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n!=0) {
            if ((n&1) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            n = n>>1;
        }

        return sb.reverse().toString();
    }
}