class Solution {
    private Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n+1];
        
        return wordCheck(0, s, wordDict);
    }
        
    private boolean wordCheck(int t, String s, List<String> list) {
        if(t == s.length()) {
            return true;      
        } else if(dp[t]!=null) {
            return dp[t];
        } else {
            for(int i = t + 1; i <= s.length(); i++) {
                if(list.contains(s.substring(t, i)) && wordCheck(i, s, list))
                    return dp[t] = true;
            }
        } 
        
        return dp[t] = false;
    }
}