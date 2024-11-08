class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i=a.length()-1;
        int j=b.length()-1;
        int sum = 0;
        int carry = 0;

        while (i>=0 && j>=0) {
            int temp = carry + Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(j)));

            sum = temp%2;
            carry = temp/2;

            sb.insert(0, sum);
            i--;
            j--;
        }

        while (i>=0) {
            int temp = carry + Integer.parseInt(String.valueOf(a.charAt(i)));

            
            sum = temp%2;
            carry = temp/2;

            sb.insert(0, sum);
            i--;
        }

        while (j>=0) {
            int temp = carry + Integer.parseInt(String.valueOf(b.charAt(j)));

            sum = temp%2;
            carry = temp/2;

            sb.insert(0, sum);
            j--;
        }

        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}