class Solution {
    
    int[][] dp; 
    
    public int lcs (String str1, String str2, int n, int m) {
        if(n==0) {
            return m;
        } else if(m==0) {
            return n;
        } else if(dp[n][m] != -1){
            return dp[n][m];
        } else if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = lcs(str1, str2, n-1, m-1);
        } else {
            return dp[n][m] = 1 + Math.min(lcs(str1, str2, n-1, m), Math.min(lcs(str1, str2, n, m-1), lcs(str1, str2, n-1, m-1)));
        }
    }
    
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int[] row: dp) {
            Arrays.fill(row , -1);
        }
        int res = lcs(word1, word2, word1.length(), word2.length());
        return res;
    }
}