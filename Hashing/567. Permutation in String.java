class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        for (char c: s1.toCharArray()) counts[c-'a']++;
        int i = 0, j = 0;
        while(j < s2.length()) {
            char c = s2.charAt(j++);
            counts[c-'a']--;
            while(counts[c-'a'] < 0) {
                char c2 = s2.charAt(i++);
                counts[c2-'a']++;
            }
            if (j-i == s1.length()) return true;
        }
        return false;
    }
}