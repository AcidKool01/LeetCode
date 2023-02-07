class Solution {
    
    HashMap<Integer, String> letter;
    List<String> ans;
    private void solve(String digits, String curr, int idx) {
        if(idx == digits.length()) {
            ans.add(curr);
            return;
        }
        
        String s = letter.get(digits.charAt(idx)-'0');
        for(int i=0; i<s.length(); i++) {
            solve(digits, curr+s.charAt(i), idx+1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        letter = new HashMap<Integer, String>();
        ans = new ArrayList<String>();
        if(digits.equals("")) return ans;
        
        letter.put(0, "");
        letter.put(1, "");
        letter.put(2, "abc");
        letter.put(3, "def");
        letter.put(4, "ghi");
        letter.put(5, "jkl");
        letter.put(6, "mno");
        letter.put(7, "pqrs");
        letter.put(8, "tuv");
        letter.put(9, "wxyz");
        
        solve(digits, "", 0);
        return ans;
    }
}