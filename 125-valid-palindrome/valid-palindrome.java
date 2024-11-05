class Solution {
	public boolean isPalindrome(String s) {
		int n = s.length();
		int start = 0;
		int end = n-1;

		while (start < end) {
			Character ch1 = getValidChar(s.charAt(start));
			if (ch1 == null) {
				start++;
				continue;
}

			Character ch2 = getValidChar(s.charAt(end));
			if (ch2 == null) {
				end--;
				continue;
}

if (ch1 != ch2) {
	return false;
}

start++;
end--;
}

return true;
}

public Character getValidChar(char ch) {
	if (
(ch >= 'a' && ch <= 'z') || 
(ch >= '0' && ch <= '9')
) {
	return ch;
} else if (ch >= 'A' && ch <= 'Z') {
	return (char)(ch-'A'+'a');
} else {
	return null;
}
}
}




