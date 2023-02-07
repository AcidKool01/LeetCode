class Solution {
    
    int[][] dp;  
    
    public int solve(int n, int i, int player, int[] arr) {
        if(i>n) {
            return 0;
        } else if(dp[i][n] != -1) {
            return dp[i][n];
        } else if(player==1) {
            return dp[i][n] = Math.max(arr[i]+solve(n, i+1, 2, arr), arr[n]+solve(n-1, i, 2, arr));
        } else {
            return dp[i][n] = Math.min(solve(n, i+1, 1, arr), solve(n-1, i, 1, arr));
        } 
    }
    
    public boolean PredictTheWinner(int[] nums) {
        dp = new int[21][21];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        int second = 0;
        
        for(Integer x: nums) {
            second+=x;
        }
        
        int first = solve(nums.length-1, 0, 1, nums);
        second = second - first;
        
        if(first>=second) {
            return true;
        } else {
            return false;
        }
    }
}