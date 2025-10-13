class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> st = new Stack<>();
        st.push(words[0]);

        for (int i=1; i<words.length; i++) {            
            String s1 = getString(st.peek());
            String s2 = getString(words[i]);
            if (s1.compareTo(s2) != 0) {
                st.push(words[i]);    
            }
        }

        List<String> ans = new ArrayList<String>();


        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        Collections.reverse(ans);

        return ans;
    }

    public String getString(String originalString) {
        // Convert the string to a character array
        char[] charArray = originalString.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Convert the sorted character array back to a string
        String sortedString = new String(charArray);

        return sortedString;
    }
}