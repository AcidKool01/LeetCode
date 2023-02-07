class Solution {
    public char findTheDifference(String s, String t) {
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        char res=' ';
        
        for(int i=0; i<s.length(); i++) hash1[s.charAt(i)-'a']++;
        for(int i=0; i<t.length(); i++) hash2[t.charAt(i)-'a']++;
        
        for(int i=0; i<26; i++) {
            if(hash2[i]!=hash1[i]) {
                res = (char)(i+'a');
            }
        }
        
        return res;
    }
}