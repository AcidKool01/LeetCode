//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static int mod = (int) 1e9+7;
    private static int[][] dp;
    private static int dpSolve(int i, int j, int[][] grid) {
        if( i == grid.length || i == -1 || j == grid[0].length || j == -1 || grid[i][j] == 0 ) return 0;
        if( i == grid.length - 1 && j == grid[0].length - 1 ) return 1;
        if( dp[i][j] != -1 ) return dp[i][j];
        
        int x = dpSolve(i+1, j, grid);
        int y = dpSolve(i, j+1, grid);
        
        return dp[i][j] = (x%mod + y%mod)%mod;
    }
    
    static int uniquePaths(int n, int m, int[][] grid) {
        dp = new int[n+1][m+1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return dpSolve(0, 0, grid);
    }
};