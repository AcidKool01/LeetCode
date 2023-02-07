class Solution {
    private int[] dp;
    private int solve(String s, int i) {
        if(i>=s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        
        int x=s.charAt(i)-'0', y=0, ans=0;
        if(i+1<s.length()) y=x*10 + (s.charAt(i+1)-'0');
        if(x>0) ans+=solve(s, i+1);
        if(x>0 && y>0 && y<=26) ans+=solve(s, i+2);
        
        return dp[i] = ans;
    }
    
    public int numDecodings(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }
}