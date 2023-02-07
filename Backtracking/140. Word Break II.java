
// Backtracking Approach 

class Solution {
    
    List<String> res = new ArrayList();
    
    public void solve (String s, String ans, List<String> wordDict) {
        if(s.length()==0) {
            res.add(ans.substring(0, ans.length()-1));
            return;
        }
        
        for (int i=0; i<s.length(); i++) {
            String left = s.substring(0, i+1);
            if(wordDict.indexOf(left)!=-1) {
                String right = s.substring(i+1);
                solve(right, ans + left + " ", wordDict);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        solve(s, "", wordDict);
        Collections.sort(res);
        return res;
    }
}