class Solution {
 
    public int countSubstrings(String s, String t) {
        char[] ss = s.toCharArray();
        int m = ss.length;
        char[] tt = t.toCharArray();
        int n = tt.length;
        int[][] same = new int[m+1][n+1]; // number of exact same substrings ending at s[i] and t[j].
        int[][] diff1 = new int[m+1][n+1]; // number of substrings having 1 different character ending at s[i] and t[j].
        int result = 0;
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if (ss[i-1] == tt[j-1]) {
                    same[i][j] = same[i-1][j-1] + 1;
                    diff1[i][j] = diff1[i-1][j-1];
                } else {
                    // same[i][j] = 0;
                    diff1[i][j] = same[i-1][j-1] + 1;
                }
                result += diff1[i][j];
            }
        }
        return result;
    }
}