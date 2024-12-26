class Solution {
    public String alienOrder(String[] words) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int[] indegree = new int[26];
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

         for (int i=0; i<words.length; i++) {
            String s1 = words[i];
            int idx = 0;
            while (idx < s1.length()) {
                hs.add(s1.charAt(idx)-'a');
                idx++;
            }
         }

        for (int i=0; i<words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            int idx = 0;
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
            idx = 0;
            while (idx < s1.length() && idx<s2.length()) {
                if (s1.charAt(idx) != s2.charAt(idx)) {
                    int start = s1.charAt(idx)-'a';
                    int end = s2.charAt(idx)-'a';
                    if (!hm.containsKey(start)) {
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(end);
                        hm.put(start, arr);
                        indegree[end]++;
                    } else {
                        hm.get(start).add(end);
                        indegree[end]++;
                    }
                    break;
                }
                idx++;
            }
        }

        for (int key : hs) {
            if (indegree[key] == 0) {
                q.offer(key);
            }
        }

        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append((char)(temp+'a'));

            if (!hm.containsKey(temp)) {
                continue;
            }

            for (int i=0; i<hm.get(temp).size(); i++) {
                indegree[hm.get(temp).get(i)]--;
                if (indegree[hm.get(temp).get(i)] == 0) {
                    q.offer(hm.get(temp).get(i));
                }
            }
        }

        if (sb.length() < hs.size()) {
            return "";
        }

        return sb.toString();
    }
}