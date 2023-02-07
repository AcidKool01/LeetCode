class Solution {
    public int minSteps(String s, String t) {
        int ans = 0;
        int[] a = new int[26];
        int[] b = new int[26];
        
        for (int i=0; i<s.length(); i++) {
            a[s.charAt(i)-'a']++;
            b[t.charAt(i)-'a']++;
        }
        
        for (int i=0; i<26; i++) {
            ans+=Math.abs(a[i]-b[i]);
        }
        
        return ans/2;
    }
}