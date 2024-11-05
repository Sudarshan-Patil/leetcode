class Solution {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> hm = new HashMap<>();
		int total = 0;
		int len = s.length()+1;
		int start = -1;
		int end = -1;
		for (int i=0; i<t.length(); i++) {
			if (!hm.containsKey(t.charAt(i))) {
	hm.put(t.charAt(i), 1);
} else {
	hm.put(t.charAt(i), hm.get(t.charAt(i))+1);
}
}
int left = 0;
for (int right=0; right<s.length(); right++) {
	char ch = s.charAt(right);

	if (!hm.containsKey(ch)) {
		continue;
}

hm.put(ch, hm.get(ch)-1);

if (hm.get(ch) == 0) {
	total++;
}

if (total == hm.size()) {
	while (!hm.containsKey(s.charAt(left)) || hm.get(s.charAt(left)) < 0){
		if (hm.containsKey(s.charAt(left))) {
			hm.put(s.charAt(left), hm.get(s.charAt(left))+1);
}
left++;
}

if (len > right-left+1) {
	len = right-left+1;
	start = left;
	end = right;
}
}
}

return len == s.length()+1 ? "" : s.substring(start, end+1);
}
}
