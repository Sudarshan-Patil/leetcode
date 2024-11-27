class Pair{
    int city;
    int distance;
    Pair(int city, int distance) {
        this.city = city;
        this.distance = distance;
    }
}
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<>();

        for (int i=1; i<n; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            temp.add(new Pair(i, 1));
            hm.put(i-1, temp);
        }

        int[] ans = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            hm.get(queries[i][0]).add(new Pair(queries[i][1], 1));
            ans[i] = bfs(hm, n);
        }

        return ans;
    }

    public int bfs(HashMap<Integer, ArrayList<Pair>> hm, int n) {
        Queue<Pair> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[] distance = new int[n];

        q.offer(new Pair(0, 0));
        vis[0] = true;
        distance[0] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (!hm.containsKey(p.city)) {
                continue;
            }

            for (int i=0; i<hm.get(p.city).size(); i++) {
                int city = hm.get(p.city).get(i).city;
                int d = hm.get(p.city).get(i).distance;
                if (!vis[city]) {
                    distance[city] = p.distance+1;
                    q.offer(new Pair(city, distance[city]));
                    vis[city] = true;
                } else if (distance[city] > p.distance+1) {
                    distance[city] = p.distance+1;
                    q.offer(new Pair(city, distance[city]));
                }
            }
        }

        return distance[n-1];
    }
}