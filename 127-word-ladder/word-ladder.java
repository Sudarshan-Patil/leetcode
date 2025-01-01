class Pair {
    String node;
    int distance;
    Pair(String node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.poll();

                if (p.node.compareTo(endWord) == 0) {
                    return p.distance;
                }

                for (String word: wordList) {
                    if(mutate(p.node, word) && !hs.contains(word)) {
                        hs.add(word);
                        q.offer(new Pair(word, p.distance+1));
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