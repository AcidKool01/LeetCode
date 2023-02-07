class Solution {
    
    int[] dp; 
    
    public int solve(int[] arr, int target) {
        if(target<0) {
            return 0;
        } else if(target==0) {
            return 1;
        } else if (dp[target] != -1) {
            return dp[target];
        } 
        int count=0;
        for(int i=0; i<arr.length; i++) {
            count += solve(arr, target-arr[i]);
        }
        
        return dp[target]=count;
    }
    
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        solve(nums, target);
        return dp[target];
    }
}