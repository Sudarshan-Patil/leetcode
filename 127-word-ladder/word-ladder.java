class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Stack<Integer> counterSt = new Stack<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.offer(beginWord);
        counterSt.push(1);

        while (!q.isEmpty()) {
            int size = q.size();
            int counter = counterSt.pop();

            while (size-- > 0) {
                String s = q.poll();

                if (s.compareTo(endWord) == 0) {
                    return counter;
                }

                for (String word: wordList) {
                    if(mutate(s, word) && !hs.contains(word)) {
                        hs.add(word);
                        q.offer(word);
                        counterSt.push(counter+1);
                    }
                }
            }
        }

        return 0;
    }

    public boolean mutate(String s1, String s2) {
        if (s1.compareTo(s2) == 0) {
            return false;
        }
        int i = 0;
        int count = 0;
        while (i<s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }

            if (count > 1) {
                return false;
            }

            i++;
        }

        return true;
    }
}