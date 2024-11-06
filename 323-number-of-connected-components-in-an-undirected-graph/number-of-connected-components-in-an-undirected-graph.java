

class Solution {
	public int countComponents(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

		for (int i=0; i<edges.length; i++) {
			int start = edges[i][0];
			int end = edges[i][1];

	if (!hm.containsKey(start)) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(end);
		hm.put(start, arr);
} else {
	hm.get(start).add(end);
}

start = edges[i][1];
end = edges[i][0];

if (!hm.containsKey(start)) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(end);
		hm.put(start, arr);
} else {
	hm.get(start).add(end);
}
}
boolean[] vis = new boolean[n];
int count = 0;
for (int i=0; i<n; i++) {
    if (!hm.containsKey(i)) {
        count++;
        continue;
    } else if (!vis[i]) {
		dfs(i, hm, vis);
	    count++;
    }
}

return count;
}




public void dfs(int key, HashMap<Integer, ArrayList<Integer>> hm, boolean[] vis) {
	if (!hm.containsKey(key) || vis[key]) {
		return;
}
	
	vis[key] = true;
	
	for (int i=0; i<hm.get(key).size(); i++) {
		dfs(hm.get(key).get(i), hm, vis);
}

return;
}
}
