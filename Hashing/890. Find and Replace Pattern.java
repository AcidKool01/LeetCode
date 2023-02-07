class Solution {
   public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String s: words){
            if(hasPattern(s, pattern)){
                res.add(s);
            }
        }
        return res;
    }
    
    private boolean hasPattern(String s, String pattern){
        int[] map = new int[26];
        int[] rmap = new int[26];
        
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            char p = pattern.charAt(i);
            if(map[p-'a'] != 0 && map[p-'a'] != c-'a'+1) return false;
            
            map[p-'a'] = c-'a'+1; 
            
            if(rmap[c-'a'] != 0 && rmap[c-'a'] != p-'a'+1) return false;
            
            rmap[c-'a'] = p-'a'+1;
        }
        
        return true;
    }
}