//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int[] dp;
    private static int dpSolve(int[][] events, int prev, int i) {
        if(i == events.length) return 0;
        if(prev!=-1 && events[prev][1] > events[i][0]) return dpSolve(events, prev, i+1); // reject before involving prev.
        if(prev!=-1 && dp[i] != -1) return dp[i];

        return dp[i] = Math.max(events[i][2] + dpSolve(events, i, i+1), dpSolve(events, prev, i+1));
    }
    
    public static int maximum_profit(int n, int[][] events) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        Arrays.sort(events, (a, b ) -> (a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        return dpSolve(events, -1, 0);
    }
}
