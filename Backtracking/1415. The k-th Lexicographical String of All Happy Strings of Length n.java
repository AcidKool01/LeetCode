// backtrack

class Solution {
    Set<String> set;
    String res;
    char[] arr = {'a', 'b', 'c'};
    private void solve(int i, int n, int k, StringBuilder sb) {
        if(i==n) {
            set.add(sb.toString());
            if(set.size()==k) {
                res = sb.toString();
            }
            return;
        }
        
        for(char c: arr) {
            if(sb.length()==0 || sb.charAt(i-1) != c) {
                sb.append(c);
                solve(i+1, n, k, sb);
                sb.deleteCharAt(sb.length()-1);                  
            }
        }
    }
    
    public String getHappyString(int n, int k) {
        set = new HashSet<String>();
        res = "";
        solve(0, n, k, new StringBuilder());
        for(String x: set) {
            System.out.print(x +", ");
        }
        return res;   
    }
}