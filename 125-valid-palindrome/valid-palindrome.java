class Solution {
	public boolean isPalindrome(String s) {
		StringBuffer sb = new StringBuffer();
		int n = s.length();
		for (int i=n-1; i>=0; i--) {
	char ch = s.charAt(i);

	if (
			(ch >= 'a' && ch <= 'z') ||
		(ch >= '0' && ch <= '9')
) {
	sb.append(ch);
} else if (ch >= 'A' && ch <= 'Z') {
	sb.append((char)(ch-'A'+'a'));
}
}

return sb.toString().compareTo(reverse(sb)) == 0;
}

public String reverse(StringBuffer sb) {
	int i = 0;
int n = sb.length();
	int j = n-1;

while (i<j) {
	char temp =sb.charAt(i);
	sb.setCharAt(i, sb.charAt(j));
	sb.setCharAt(j, temp);
	i++;
	j--;
}

return sb.toString();
}
}




