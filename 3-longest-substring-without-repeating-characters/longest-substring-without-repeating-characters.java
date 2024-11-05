class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashSet<Character> hs = new HashSet<>();
		int len = 0;
		int left = 0;
int right = 0;
int n = s.length();
while (right < n) {
	if (hs.contains(s.charAt(right))) {
		hs.remove(s.charAt(left));
		left++;
} else {
	hs.add(s.charAt(right));
	len = Math.max(len, right-left+1);
	right++;
}
}

return len ;
}
}
