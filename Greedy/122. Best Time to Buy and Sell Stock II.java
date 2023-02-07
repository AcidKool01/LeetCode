
// scam :(

class Solution {
    
    // public int solve(int curr, int n, int[] prices) {
    //     if(n==prices.length-1) {
    //         return 0;
    //     } 
    //     else if(curr>prices[n]) {
    //         return Math.max(solve(curr+prices[n], n+1, prices), solve(curr, n+1, prices));
    //     } 
    //     else {
    //         return Math.max((prices[n]-curr) + solve(prices[n], n+1, prices), solve(curr, n+1, prices));
    //     }
    // }
    
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) 
            profit += Math.max(0, prices[i] - prices[i - 1]);
        
        return profit;
    }
}