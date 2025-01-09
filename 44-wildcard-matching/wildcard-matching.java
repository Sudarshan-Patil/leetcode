public class Solution {
    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            if (i>0 && B.charAt(i) == '*' && sb.charAt(sb.length()-1) == '*') {
                continue;
            }
            sb.append(B.charAt(i));
        }
        String s = sb.toString();
        m = s.length();

        int[][] dp = new int[n][m];
       
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return matching(A,s,n-1,m-1,dp) == 1;
    }
    public int matching(String A,String B,int i,int j,int[][] dp){
        if(i<0 && j<0) return 1;
        //if still chars left in B
        if(i<0){
            while(j>=0){
                if(B.charAt(j) != '*') {
                    return 0;
                }
                j--;
            }
            return 1;
        }
        //if still chars left in A
        if(j<0) return 0;

        if(dp[i][j]==-1){
            //if chars are equal check the previous one.
            if(A.charAt(i) == B.charAt(j) || B.charAt(j)=='?'){
                dp[i][j] = matching(A,B,i-1,j-1,dp);
            }
            // Three possibilities if B char is *
            else if(B.charAt(j)=='*'){
                //while(j-1>=0 && (B.charAt(j)== '*' && B.charAt(j-1) =='*')) j--;
                dp[i][j] = matching(A,B,i-1,j,dp) | matching(A,B,i,j-1,dp);
            }
            
            //if char are not equal return 0
            else{
                dp[i][j] = 0;
            }
        }
        return dp[i][j];
    }
}