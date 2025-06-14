class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int max = 0;
        int min = 0;
        // Try all digits 0-9 for max
        int i=0;
        while (i<numStr.length()) {
            if (numStr.charAt(i) != '9') {
                break;
            }
            i++;
        }
        
        if (i < numStr.length()) {
            char c = numStr.charAt(i);
            String r1 = numStr.replace(c, '9');
        
            max = Integer.parseInt(r1);
        } else {
            max = Integer.parseInt(numStr);
        }

        i=0;
        while (i<numStr.length()) {
            if (numStr.charAt(i) != '0') {
                break;
            }
            i++;
        }

        if (i < numStr.length()) {
            char d = numStr.charAt(i);
            String r2 = numStr.replace(d, '0');
        
            min = Integer.parseInt(r2);
        } else {
            min = Integer.parseInt(numStr);
        }

        
        
        return max - min;
    }
}