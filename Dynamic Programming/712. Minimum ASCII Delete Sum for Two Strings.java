class Solution {
    public int getsum(String s1, String s2, int m, int n, int[][]dp) {
        if(dp[m][n] != -1)
            return dp[m][n];

        if(n == 0 && m == 0) {
            return 0; 
        } else if(m == 0) {
            dp[m][n] = getsum(s1, s2, m, n-1, dp) + (s2.charAt(n-1));
        } else if(n == 0){
            dp[m][n] = getsum(s1, s2, m-1, n, dp) + (s1.charAt(m-1));
        } else if(s1.charAt(m-1) == s2.charAt(n-1)){
            dp[m][n] = getsum(s1, s2, m-1, n-1, dp);
        } else{
            dp[m][n] = Math.min( 
                                 getsum(s1, s2, m, n-1, dp) + (s2.charAt(n-1)), 
                                 getsum(s1, s2, m-1, n, dp) + (s1.charAt(m-1))
                               );
        }
        
        return dp[m][n];
    }

    public int minimumDeleteSum(String s1, String s2) {       
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return getsum(s1, s2, m, n, dp);
    }
}