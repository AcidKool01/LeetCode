class Solution {
    private int[] dp;
    private int solve(int[] arr, int d, int index) {
        if(index<0 || index>=arr.length) return 0;
        if(dp[index] != -1) return dp[index];

        int result1 = 0; 
        
        for(int i =1; i<=d;i++) {
            if(index+i >= arr.length || arr[index+i] >= arr[index]) break; 
                result1 = Math.max(result1, 1 + solve(arr,d,index+i)); 
        }
        
        int result2 = 0; 
        for(int i =1; i<=d;i++) {
            if(index-i < 0 || arr[index-i] >= arr[index]) break; 
                result2 = Math.max(result2, 1 + solve(arr,d,index-i)); 
        }
        
        int jump = Math.max(result1, result2);
        return dp[index] = jump;
    }
    
    public int maxJumps(int[] arr, int d) {
        int n = arr.length, res = 0;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        for(int i=0; i<arr.length; i++) {
            res = Math.max(res, solve(arr, d, i));
        }
        
        return res+1;
    }
}