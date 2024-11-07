class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        int ans = 1;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0; i<n; i++) {
                StringBuilder s = new StringBuilder(q.poll());
                for (int j=0; j<s.length(); j++) {
                    char old = s.charAt(j);
                    for (int k=0; k<26; k++) {
                        char t = (char)('a' + k);
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


        return 0;
    }
}