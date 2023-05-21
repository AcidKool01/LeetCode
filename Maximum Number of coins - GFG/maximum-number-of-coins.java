//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private int[][] dp;
    private int dpSolve(int i, int j, int[] arr) {
        if( i > j ) return 0;
        if( dp[i][j] != -1 ) return dp[i][j];
        
        int res = 0;
        for(int k=i; k<=j; k++) {
            res = Math.max(res, (i-1 >=0 ? arr[i-1] : 1) * ( j+1 < arr.length ? arr[j+1] : 1 ) * arr[k] + dpSolve(i, k-1, arr) + dpSolve(k+1, j, arr));
        }
        
        return dp[i][j] = res;
    }
    
    int maxCoins(int N, ArrayList<Integer> list) {
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        dp = new int[N+1][N+1];
        for(int[] d: dp) Arrays.fill(d, -1);
		return dpSolve(0, N-1, arr);
	}
}