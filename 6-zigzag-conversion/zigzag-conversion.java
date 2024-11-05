class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i=0; i<numRows; i++) 
        {
            sb[i] = new StringBuffer();
        }
        
        int n = s.length();
        int i=0;
        while (i<n) {
            for (int j=0; j<numRows && i<n; j++) {
                sb[j].append(s.charAt(i++));
            }

            for (int j=numRows-2; j>0 && i<n; j--) {
                sb[j].append(s.charAt(i++));
            }
        }

        i = 1;
        while (i<numRows) {
            sb[0].append(sb[i]);
            i++;
        }

        return sb[0].toString();
    }
}