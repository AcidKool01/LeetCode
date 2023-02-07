class Solution {
    
    public int solve(String str1, String str2, int n, int m, int[][] dp) {
        if(n==0 || m==0) {
            return 0;
        }
        
        if(dp[n][m]!=-1) {
            return dp[n][m];
        }
        
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            dp[n][m] = 1+solve(str1, str2, n-1, m-1, dp);
        } else {
            return dp[n][m] = Math.max(solve(str1, str2, n-1, m, dp), solve(str1, str2, n, m-1, dp));
        }  
        return dp[n][m];
	}
    
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m  =word2.length();
        int[][] dp = new int[n+1][m+1];
        
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<m+1; j++) {
                dp[i][j] = -1;
            }  
        }

        solve(word1, word2, n, m, dp);
        int res = (n-dp[n][m]) + (m-dp[n][m]);
        
        return res;
    }
}