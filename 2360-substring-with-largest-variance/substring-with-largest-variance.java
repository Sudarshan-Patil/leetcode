class Solution {
    public int largestVariance(String s) {
        int len = s.length();
        int[] counter = new int[26];
        int ans = 0;

        for (int i=0; i<len; i++) {
            counter[s.charAt(i)-'a']++;
        }

        for (int i=0; i<26; i++) {
            for (int j=0; j<26; j++) {
                if (i==j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }

                char major = (char)('a'+i);
                char minor = (char)('a'+j);

                int majorCounter = 0;
                int minorCounter = 0;

                int restCounter = counter[j];

                for (char ch : s.toCharArray()) {
                    if (ch == major) {
                        majorCounter++;
                    }

                    if (ch == minor) {
                        minorCounter++;
                        restCounter--;
                    }

                    if (minorCounter > 0) {
                        ans = Math.max(ans, majorCounter-minorCounter);
                    }

                    if (majorCounter < minorCounter && restCounter > 0) {
                        majorCounter = 0;
                        minorCounter = 0;
                    }
                }
            }
        }

        return ans;
    }
}