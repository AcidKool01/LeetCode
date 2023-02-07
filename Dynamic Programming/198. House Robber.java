class Solution {
    
    int[] dp;
    
    public int solve(int[] nums, int n) {
        if(n<=0) {
            return 0;
        } else if(dp[n]!=-1) {
            return dp[n];
        }
        
        int x = solve(nums, n-1);
        int y = solve(nums, n-2) + nums[n-1];
        
        return dp[n] = Math.max(x, y);
    }
    
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(nums, nums.length);
    }
}