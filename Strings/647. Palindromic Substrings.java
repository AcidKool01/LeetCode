class Solution {
    private int count;
    
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==0) return 0;
        
        for(int i=0; i<n; i++) {
            extendPalindromes(s, i, i);
            extendPalindromes(s, i, i+1);
        }
        
        return count;
    }
    
    private void extendPalindromes(String str, int left, int right) {
        while(left>=0 && right<=str.length()-1 && str.charAt(left)==str.charAt(right)) {
            count++; left--; right++;
        }
    }
}