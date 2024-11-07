class Solution {
public int minMutation(String startGene, String endGene, String[] bank) {
	HashMap<String, Integer> hm = new HashMap<>();
	for (int i=0; i<bank.length; i++) {
		if (!hm.containsKey(bank[i])) {
			hm.put(bank[i], 1);
} else {
	hm.put(bank[i], hm.get(bank[i])+1);
}
}

		Queue<String> q = new LinkedList<>();
		Queue<Integer> counter = new LinkedList<>();

		q.offer(startGene);
		counter.offer(0);

		while (!q.isEmpty()) {
			String s = q.poll();
int count = counter.poll();

if (s.equals(endGene)) {
	return count;
}

for (String key:hm.keySet()) {
	if (mutate(s, key) && hm.get(key) > 0) {
	q.offer(key);
	counter.offer(count+1);
	hm.put(key, hm.get(key)-1);
}
}
}

return -1;
}

public boolean mutate(String s1, String s2) {
	int i=0;
	int countlen = 0;
	while (i<s1.length()) {
		if (s1.charAt(i) != s2.charAt(i)) {
			countlen++;
}

if (countlen > 1) {
	return false;
}
i++;
}
return true;
}
}
