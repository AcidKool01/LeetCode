
// Not effecient :(

class Solution {
    
    int[][] dp;
    
    public int solve(int[] arr, int k, int n) {
        if(n==0) {
            return 0;
        } else if(k==0) {
            return 0;
        } else if(dp[n][k]!=-1) {
            return dp[n][k];
        }
              
        int curr = arr[n-1], profit = 0;
        
        for (int i=n-1; i>=0; i--) {
            profit = Math.max(profit, (curr-arr[i]) + solve(arr, k-1, i));
        }
        
        return dp[n][k] =  Math.max(solve(arr, k, n-1), profit);
    }
    
    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length+1][k+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(prices, k, prices.length);
    }
}

//
