class Solution {
    public boolean isMatch(String s, String p) {
        boolean match[][] = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < p.length(); i++) // judge whether the substring of p matchese empty sequence
            if (p.charAt(i) == '*')
                match[0][i + 1] = match[0][i];
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < p.length(); j++) {
                if( p.charAt(j) == '*' )
                    match[i + 1][j + 1] = (match[i][j + 1] | match[i + 1][j] | match[i][j]);
                else if( s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' )
                    match[i + 1][j + 1] = match[i][j];
            }
        return match[s.length()][p.length()];
    }
}s