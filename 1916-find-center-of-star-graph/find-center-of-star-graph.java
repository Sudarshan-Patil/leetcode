class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i=0; i<edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];

            if (!hm.containsKey(s)) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(e);
                hm.put(s, t);
            } else {
                hm.get(s).add(e);
            }

            if (!hm.containsKey(e)) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(s);
                hm.put(e, t);
            } else {
                hm.get(e).add(s);
            }
        }

        int n = hm.size()-1;
        for (int key:hm.keySet()) {
            if (hm.get(key).size() == n) {
                return key;
            }
        }

        return -1;
    }
}