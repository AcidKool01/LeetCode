class Solution {
    
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        int max = 0;
        int[][] dp = new int[len][len];
        
        for (int i = 2; i < len; i++) { 
            int lo = 0, hi = i-1;
            while (lo < hi) {
                int sum = arr[lo] + arr[hi];
                if (sum < arr[i]) {
                    lo++;
                } else if (sum > arr[i]) {
                    hi--;
                } else { 
                    dp[hi][i] = dp[lo][hi] + 1;
                    max = Math.max(max, dp[hi][i]);
                    lo++;
                    hi--;
                }
            }
        }
        
        return max > 0 ? max+2 : 0; 
    }
}