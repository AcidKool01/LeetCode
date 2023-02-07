class Solution {
    private int[][] dp;
    private int solve(int[][] arr, int i, int j) {
        if(i==arr.length) return 0;
        if(dp[i][j+1] != -1) return dp[i][j+1];
        int x=0, y=0;
        
        x = solve(arr, i+1, j);
        if(j==-1 || arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
            y = 1+solve(arr, i+1, i);
        }
        return dp[i][j+1] = Math.max(x, y);
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0]-b[0]);
        dp = new int[envelopes.length+2][envelopes.length+2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(envelopes, 0, -1);
    }
}

// optimized bs + sort

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        List<Integer> result = new ArrayList<>();
        result.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; ++i) {
            if (result.get(result.size() - 1) < envelopes[i][1])
                result.add(envelopes[i][1]);
            else {
                int idx = Collections.binarySearch(result, envelopes[i][1]);
                result.set(idx < 0 ? -idx - 1 : idx, envelopes[i][1]);
            }
        }
        return result.size();
    }
}