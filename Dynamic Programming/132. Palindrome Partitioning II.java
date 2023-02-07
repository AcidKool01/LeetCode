class Solution {
    
    int[][] dp = new int [2002][2002];

    boolean isPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public int solve(String s, int i, int j) {
        if(i>=j) {
            return 0;
        } 
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if(isPalindrome(s, i, j)) {
            dp[i][j] = 0;
            return 0;
        }
        
        int minPartition = Integer.MAX_VALUE;
        
        for (int k=i; k<j; k++) {
        /*An Optimization: We will make the partition only if the string till the partition 
	(till Kth position) is a valid palindrome. Because the question states that all 
	partition must be a valid palindrome. If we dont check this, we will have to 
	perform recursion on the left subproblem too (solve(str, i, k)) and	we will waste 
	a lot of time on subproblems that is not required. Without this the code will give
	correct answer but TLE on big test cases. */
            if(isPalindrome(s, i, k)) {
                int temp = 1 + solve(s, k+1, j);
                minPartition = Math.min(minPartition, temp);              
            }
        }
        
        return dp[i][j] = minPartition;
    }
    
    public int minCut(String s) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int ans = solve(s, 0, s.length()-1);
        return ans;
    }
}