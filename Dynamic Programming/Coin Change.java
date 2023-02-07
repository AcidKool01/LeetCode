//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        long[][] dp = new long[m+1][n+1];
        for(int i=0; i<=m; i++) dp[i][0]=1;
        for(int j=0; j<=n; j++) dp[0][j]=0;
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(j>=S[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-S[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}