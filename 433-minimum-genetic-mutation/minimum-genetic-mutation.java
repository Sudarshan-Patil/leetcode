class Solution {
    public int minMutation(String beginWord, String endWord, String[] wordList) {
        HashSet<String> hs = new HashSet<>(Arrays.asList(wordList));
        HashSet<Character> hsChar = new HashSet<>();
        hsChar.add('A');
        hsChar.add('C');
        hsChar.add('G');
        hsChar.add('T');

        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        int ans = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0; i<n; i++) {
                StringBuilder s = new StringBuilder(q.poll());
                for (int j=0; j<s.length(); j++) {
                    char old = s.charAt(j);
                    for (char t:hsChar) {
                        s.setCharAt(j, t);
                        String temp = s.toString();
                        if (hs.contains(temp)) {
                            if (temp.equals(endWord)) {
                                return ans + 1;
                            }
                            hs.remove(temp);
                            q.offer(temp);
                        }
                    }
                    s.setCharAt(j, old);
                }
            }
            ans++;
        }


        return -1;
    }
}