class Solution {
    int[] dp = new int[366];
    
    int minimum(int[] days , int idx , int[] costs)
    {
        if(idx==days.length) return dp[idx]= 0; 
        if(dp[idx]!=-1) return dp[idx];
        
        int ind = idx , ind1 = idx;
        while(ind<days.length && (days[idx]+7)>days[ind]) ind++;
        while(ind1<days.length && (days[idx]+30)>days[ind1]) ind1++;
        
           
        int a = costs[0] + minimum(days , idx+1 , costs);
        int b = costs[1] + minimum(days , ind , costs);
        int c = costs[2] + minimum(days , ind1 , costs);
        
        return dp[idx]= Math.min(a , Math.min(b , c));
    }

    
    public int mincostTickets(int[] days, int[] costs) {
        for(int i=0;i<366;i++) dp[i] = -1;
        return minimum(days , 0 , costs);
    }
}