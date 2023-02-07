class Solution {
    private List<String> res;
    
    private void solve(String str, int open, int close, int n) {
        if(str.length() == 2*n) {
            res.add(str);
            str = "";
            return;
        }
        
        if(open < n) {
            solve(str + '(', open + 1, close, n);
        }
        
        if(close < open) {
            solve(str + ')', open, close + 1, n);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        solve("", 0, 0, n);
        return res;
    }
}