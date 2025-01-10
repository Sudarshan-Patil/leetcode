class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bmax = new int[26];
        List<String> ans = new ArrayList<String>();
        for (int i=0; i<words2.length; i++) {
            int[] bword = countChar(words2[i]);
            for (int j=0; j<26; j++) {
                bmax[j] = Math.max(bmax[j], bword[j]);
            }
        }
        
        // display(bmax);
        for (int i=0; i<words1.length; i++) {
            int[] aword = countChar(words1[i]);
            
            // display(aword);
            boolean isUniversal = true;
            for (int j=0; j<26; j++) {
                if (bmax[j] > aword[j]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                ans.add(words1[i]);
            }
        }

        return ans;
    }

    public void display(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return;
    }

    public int[] countChar(String s) {
        int[] charCount = new int[26];
        for (int j=0; j<s.length(); j++) {
            charCount[s.charAt(j)-'a']++;
        }

        return charCount;
    }
}