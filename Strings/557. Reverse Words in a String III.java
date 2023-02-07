
// For Bettering JAVA :)

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String res = "";
        for(String word: words) {
            StringBuffer sbr = new StringBuffer(word);
            sbr.reverse();
            sbr.toString();
            res += sbr + " ";
        }
        return res.substring(0, res.length()-1);
    }
}

// Native Solution

lass Solution {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = 0;
        for (;j<c.length;j++) {
            if (c[j] == ' ') {
                reverseWord(c, i, j-1);
                i = j+1;
            } 
        }
        reverseWord(c, i, j-1);
        return new String(c);
    }
    
    private void reverseWord(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }
}