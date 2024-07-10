class Solution {
    public int minOperations(String[] logs) {
        int t = 0;

        for (int i=0; i<logs.length; i++) {
            if (logs[i].equals("../")) {
                if (t > 0) {
                    t -= 1;
                }
            } else if (logs[i].equals("./")) {
                //do nothing
            } else {
                t += 1;
            }
        }

        return t > 0 ? t : 0;
    }
}