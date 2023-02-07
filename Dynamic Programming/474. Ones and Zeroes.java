class Solution {
    private int[][][] dp;
    private int solve(int[][] str, int i, int m, int n) {
        if(m<0 || n<0) return -1;
        // if(m==-1 && n==-1) return 0;
        if(i==str.length) return 0;
        if(dp[i][m][n] != -1) return dp[i][m][n];
        
        return dp[i][m][n] = Math.max(1 + solve(str, i+1, m-str[i][0], n-str[i][1]), solve(str, i+1, m, n));
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length+1][m+1][n+1];
        for(int i=0; i<strs.length+1; i++) { for(int j=0; j<m+1; j++) { Arrays.fill(dp[i][j], -1); } }
        int[][] str = new int[strs.length][2];
        for(int i=0; i<strs.length; i++) {
            String temp = strs[i];
            for(int j=0; j<temp.length(); j++) {
                if(temp.charAt(j)=='0') str[i][0]++;
                else str[i][1]++;
            }
        }

        return solve(str, 0, m, n);
    }
}