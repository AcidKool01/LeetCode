
// Top-Down DP

class Solution {
    
    int[][] dp = new int[1002][1002];
    
    public int solve (String str1, String str2, int n, int m) {
        if(n==0 || m==0) {
            return 0;
        } else if(dp[n][m]!=-1) {
            return dp[n][m];
        } else if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = 1+solve(str1, str2, n-1, m-1);
        } else {
            return dp[n][m] = Math.max(solve(str1, str2, n-1, m), solve(str1, str2, n, m-1));
        }
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        int res = solve(text1, text2, text1.length(), text2.length());
        return dp[text1.length()][text2.length()];
    }
}

// Bottom-UP

class Solution {
    
//     public int solve (String str1, String str2, int n, int m) {
//         if(n==0 || m==0) {
//             return 0;
//         } else if(dp[n][m]!=-1) {
//             return dp[n][m];
//         } else if (str1.charAt(n-1) == str2.charAt(m-1)) {
//             return dp[n][m] = 1+solve(str1, str2, n-1, m-1);
//         } else {
//             return dp[n][m] = Math.max(solve(str1, str2, n-1, m), solve(str1, str2, n, m-1));
//         }
//     }
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                if(i==0) {
                    dp[i][j] = 0;
                } 
                if(j==0) {
                    dp[i][j] = 0;
                }
            }
        }
        
        // dp[0][0] = 1;
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
}