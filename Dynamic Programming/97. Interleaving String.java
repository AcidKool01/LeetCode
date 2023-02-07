class Solution {
    
    Boolean[][] dp;
    
    public boolean solve(String s1, String s2, String s3, int n, int m, int k) {
        
        if(n==0 && m==0 && k==0) return true;
        if(n>0 && m>0 && dp[n][m]!=null) return dp[n][m];
        
        if(n>0 && k>0 && s1.charAt(n-1)==s3.charAt(k-1) && m>0 && s2.charAt(m-1)==s3.charAt(k-1)) {
            return dp[n][m] = solve(s1,s2,s3,n-1,m,k-1) || solve(s1,s2,s3,n,m-1,k-1);
        } else if(m>0 && k>0 && s2.charAt(m-1)==s3.charAt(k-1)) {
            return dp[n][m] = solve(s1,s2,s3,n,m-1,k-1);
        } else if(n>0 && k>0 && s1.charAt(n-1)==s3.charAt(k-1)) {
            return dp[n][m] = solve(s1,s2,s3,n-1,m,k-1);
        }
        
        return false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1,s2,s3,s1.length(),s2.length(),s3.length());
    }
}