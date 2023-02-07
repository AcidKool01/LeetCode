class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i=1; i<n; i++) {
            if(ratings[i-1] < ratings[i]) {
                ans[i] = ans[i-1] + 1;
            } 
        }
        for (int i= n-1; i>0 ; i--) {
		    if(ratings[i-1]>ratings[i])
			    ans[i-1]=Math.max(ans[i]+1, ans[i-1]);
	    }
        
        int res = 0;
        for (int i=0; i<n; i++) {
            res = res + ans[i];
        }
        
        return res;
    }
}