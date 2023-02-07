class Solution {
    private List<String> res;
    
    private boolean isValid(String str) {
        if(str.charAt(0)=='0') return false;
        return Integer.parseInt(str) <=255;
    }
    
    private void solve(String str, int i, int pp, String ans) {
        if(i==str.length() || pp==4) {
            if(i==str.length() && pp==4) res.add(ans.substring(0, ans.length()-1));
            return;
        }
        
        solve(str, i+1, pp+1, ans+str.charAt(i)+".");
        if(str.length() > i+1 && isValid(str.substring(i,i+2))) 
            solve(str, i+2, pp+1, ans+str.substring(i, i+2)+".");
        if(str.length() > i+2 && isValid(str.substring(i,i+3))) 
            solve(str, i+3, pp+1, ans+str.substring(i, i+3)+".");
    }
    
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        res = new ArrayList<String>();
        
        solve(s, 0, 0, "");
        return res;
    }
}