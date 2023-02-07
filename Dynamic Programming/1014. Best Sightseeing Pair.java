class Solution {
    private int[][][] dp;
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        dp = new int[n+1][2][3];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<2; j++) {
                for (int k=0; k<3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(values, 0, false, 0);
    }
    
    private int solve(int[] arr, int i, boolean turn, int k) {
        if(k==1) return 0;
        if(i==arr.length) return (int)-1e9;  
        int t =1;
        if(turn == false) t = 0;
        if(dp[i][t][k] != -1) return dp[i][t][k];
        
        if(!turn) {
            return dp[i][t][k] = Math.max(arr[i]+i + solve(arr, i+1, !turn, k), solve(arr, i+1, turn, k));
        } else {
            return dp[i][t][k] = Math.max(arr[i]-i + solve(arr, i+1, !turn, k+1), solve(arr, i+1, turn, k));
        }
    }
}