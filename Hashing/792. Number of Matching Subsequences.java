class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap < String, Integer > hash = new HashMap();
        for(String word: words){
            hash.put(word, hash.getOrDefault(word, 0)+1);
        }

        char [] sArr = s.toCharArray();
        for (Map.Entry<String, Integer> entry: hash.entrySet()) {
            char[] word = entry.getKey().toCharArray();
            int sItr = 0, wItr = 0;
            while ( sItr < sArr.length && wItr < word.length) {
                if (sArr[sItr] == word[wItr]) wItr++;
                sItr++;
            }
            if (wItr == word.length) {
                count+=entry.getValue();
            }
        }
        return count;
    }
}