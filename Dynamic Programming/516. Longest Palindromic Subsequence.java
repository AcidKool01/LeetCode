class Solution {
    
    int[][] dp = new int[1002][1002]; 
    
    public int solve(String str1, String str2, int n, int m) {
        if(n==0 || m==0) {
            return 0;
        } else if(dp[n][m] != -1) {
            return dp[n][m];
        } else if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = 1+solve(str1, str2, n-1, m-1);
        } else {
            return dp[n][m] = Math.max(solve(str1, str2, n-1, m), solve(str1, str2, n, m-1));
        }
    }
    
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String p = "";
        for (int[] row: dp)
            Arrays.fill(row, -1);
        
        for (int i=0; i<n; i++) {
            p = s.charAt(i) + p;
        }
        
        int res = solve(s, p, n, n);
        return dp[n][n];
    }
}