class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<String>();
        Queue<Integer> tracker = new LinkedList<Integer>();
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i=0; i<bank.length; i++) {
            if (!hm.containsKey(bank[i])) {
                hm.put(bank[i], 1);
            } else {
                hm.put(bank[i], hm.get(bank[i])+1);
            }
        }

        tracker.offer(0);
        q.offer(startGene);
        while(!q.isEmpty()) {
            String s = q.poll();
            int count = tracker.poll();

            if (s.equals(endGene)) {
                return count;
            }

            for (String key:hm.keySet()) {
                if (mutate(s, key) && hm.get(key) > 0) {
                    q.offer(key);
                    tracker.offer(count+1);
                    hm.put(key, hm.get(key)-1);
                }
            }
        }

        return -1;
    }

    public boolean mutate(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i=0; i<n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }

}