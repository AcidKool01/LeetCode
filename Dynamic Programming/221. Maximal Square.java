class Solution {
    int[][] dp;
    private int solve (char[][] matrix, int n, int m) {
        if(n<0 || n>=matrix.length || m<0 || m>=matrix[0].length || matrix[n][m]=='0') return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        
        int a = solve(matrix, n+1, m);
        int b = solve(matrix, n, m+1);
        int c = solve(matrix, n+1, m+1);
        
        return dp[n][m] = 1 + Math.min(Math.min(a, b), c);
    }
    
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        dp = new int[n+1][m+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(matrix[i][j]=='1') ans = Math.max(ans, solve(matrix, i, j));
            }
        }
        
        return ans==Integer.MIN_VALUE ? 0 : ans*ans;
    }
}