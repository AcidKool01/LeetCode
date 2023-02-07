class Solution {
    int[][] dp;
    private int solve(int[] arr, int i, int p) {
        if(i==arr.length) return 0;
        if(dp[i][p]!=-1) return dp[i][p];
        
        return dp[i][p] = Math.max(arr[i]*p + solve(arr, i+1, p+1), solve(arr, i+1, p));
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        Arrays.sort(satisfaction);
        
        return solve(satisfaction, 0, 1);
    }
}

// greedy

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int total = 0,res = 0;
        Arrays.sort(satisfaction);
        for(int i = satisfaction.length-1;i >= 0 && satisfaction[i] > -total;i--){
            total += satisfaction[i];
            res += total;
        }
        return res;
    }
}