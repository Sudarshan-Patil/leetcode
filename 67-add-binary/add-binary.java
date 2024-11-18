class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i=a.length()-1;
        int j=b.length()-1;
        int sum = 0;
        int carry = 0;

        while (i>=0 && j>=0) {
            int temp = carry + a.charAt(i)-'0' + b.charAt(j)-'0';

            sum = temp%2;
            carry = temp/2;

            sb.append(sum);
            i--;
            j--;
        }

        while (i>=0) {
            int temp = carry + a.charAt(i)-'0';

            
            sum = temp%2;
            carry = temp/2;

            sb.append(sum);
            i--;
        }

        while (j>=0) {
            int temp = carry + b.charAt(j)-'0';

            sum = temp%2;
            carry = temp/2;

            sb.append(sum);
            j--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}