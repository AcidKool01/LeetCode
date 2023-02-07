class Solution {
    public int titleToNumber(String str) {
        // return (int) Math.pow(26, columnTitle.length()-1) + (int)(columnTitle.charAt(columnTitle.length()-1)-'A'+1); 
        int n = str.length();
        int res = 0;
        for (int i=n-1; i>=0; i--) {
            res = res + (int)(str.charAt(i) - 'A' + 1)*(int)Math.pow(26, n-i-1);
        }
        return res;
    }
}