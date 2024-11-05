class Solution {
	public boolean isSubsequence(String s, String t) {
		int i = 0;
		int j = 0;

		int slen = s.length();
		int tlen = t.length();

		while (i<slen && j<tlen) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
} else {
	j++;
}
}

return i == slen;
}
}
