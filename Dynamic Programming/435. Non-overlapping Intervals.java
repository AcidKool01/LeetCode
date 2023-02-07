// dp X TLE

class Solution {
    private int[][] dp;
    private int solve(int[][] intervals, int i, int j) {
        if(i==intervals.length) return 0;
        if(dp[i][j+1] != -1) return dp[i][j+1];
        int x=Integer.MAX_VALUE, y;
        if(j==-1 || intervals[i][0] >= intervals[j][1]) {
            x = solve(intervals, i+1, i);
        }
        y = 1 + solve(intervals, i+1, j);
        
        return dp[i][j+1] = Math.min(x, y);
    }
    
    public int eraseOverlapIntervals(int[][] intervals) { 
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = intervals.length;
        dp =new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(intervals, 0, -1);
    }
}

// greedy X sort x Accepted
  
    public int eraseOverlapIntervals(int[][] intervals) { 
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = intervals.length;

        int count = 0;
        int prevEnd = intervals[0][1];
        for (int i =1 ;i <n ;i++  ){
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (a>=prevEnd) {
                prevEnd = b;
            } else {      
                count++;
                prevEnd = Math.min(prevEnd ,b);
            }
            
        }
        return count;
    }
}

