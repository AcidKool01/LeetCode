class Solution {
    
    public boolean solve(int[] nums, int n, int m, boolean[][] dp) {
        for (int i=0; i<=n; i++){
            for(int j=0; j<=m; j++) {
                if(i==0) {
                    dp[i][j] = false;
                } else if(j==0) {
                    dp[i][j] = true;
                } else if(j<nums[i-1]) {
                    dp[i][j]= dp[i-1][j];
                } else {
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][m];
    }
    
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum+=nums[i];
        }
        if(sum%2==1) {
            return false;
        } 
        
        boolean[][] dp = new boolean[n+1][sum+1];
        
        return solve(nums, n, sum/2, dp);
    }
}

// Effecient Copy-paste  ;-;

class Solution {
      public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums ){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        sum = sum/2;
        Boolean memo[] =  new Boolean[sum+1];
        return memoization(nums,memo,0,sum);        
    }    
    boolean memoization(int nums[], Boolean memo[] , int index , int target ){
        
      if(target==0) return true;        
      if(target<0 || index>=nums.length ) return false;
            
        if(memo[target]!=null) return memo[target];
        
        boolean res1 = memoization(nums,memo,index+1,target-nums[index]) ;
        if(res1)  return memo[target] = res1;
        boolean res2 =  memoization(nums,memo,index+1,target);        
        return memo[target] = res2;                                
    }
}