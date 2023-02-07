class Solution {
    
    public int solve(ArrayList<ArrayList<Integer>> dp, int n, int m) {
        if(n==1 || m==1) {
            return 1;
        }
        
        if(dp.get(n).get(m) != -1) {
            return dp.get(n).get(m);
        }
        
        int x=0, y=0;
        
        if(n!=1) {
            x = solve(dp, n-1, m);
        }
        
        if(m!=1) {
            y = solve(dp, n, m-1);
        }
        
        dp.get(n).set(m, x+y);
        
        return x+y;
    }
    
    public int uniquePaths(int n, int m) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>(n+1);
        for (int i=0; i<=n; i++) {
            dp.add(new ArrayList<>());
        }
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                dp.get(i).add(j, -1);
            }
        }
        
        dp.get(1).set(1, 1);
        int res = solve(dp, n, m);
        
        return res;
    }
}


// Bottom-Up Approach

class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        int i = 0,j = 0;

        for(i = 0;i < m;i++)
            arr[i][0] = 1;
        for(j = 0;j < n;j++)
            arr[0][j] = 1;
        for(i = 1;i < m;i++)
        {
            for(j = 1;j < n;j++)
            {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}