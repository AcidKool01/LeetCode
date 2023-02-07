class Solution {
    private int[][] dp; 
    private int mod;
    private int solve(int[] arr, int i, int prev) {
        if(i==arr.length) return prev==2 ? 1 : 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int ans=0, notTake=solve(arr, i+1, prev);
        if(prev==arr[i]-1 || prev==arr[i]) ans += solve(arr, i+1, arr[i])%mod;
        
        return dp[i][prev+1] = (ans%mod+notTake%mod)%mod;
    }
    
    public int countSpecialSubsequences(int[] nums) {
        mod=(int)1e9+7;
        dp = new int[nums.length+1][4];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(nums, 0, -1)%mod;
    }
}