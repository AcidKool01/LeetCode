class Solution {
    
    int[][] dp;
    
    public int solve(int[][] arr, int n, int m) {
        if(n==arr.length-1 && m==arr[0].length-1 && arr[n][m]==0) {
            return 1;
        } 
        if(n>arr.length-1 || m>arr[0].length-1 || arr[n][m]==1) {
            return 0;
        }
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
    
    
        int x = solve(arr, n+1, m);
        int y = solve(arr, n, m+1);
        
        return dp[n][m] = x+y;
    }
    
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        dp = new int[n+1][m+1];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        return solve(arr, 0, 0);
    }
}