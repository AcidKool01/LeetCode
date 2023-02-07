class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long cur[] = new long[primes.length];
		long dp[] = new long[n+1];
		dp[0]=1;
		int index=1;
		while(index<n){
			long min=Long.MAX_VALUE;
			for(int i=0;i<primes.length;i++){
				min=Math.min(min, dp[(int)cur[i]]*primes[i]);
			}
			dp[index++]=min;
			for(int i=0;i<primes.length;i++){
				if(min == dp[(int)cur[i]]*primes[i])
					cur[i]++;
			}
		}
		return (int)dp[n-1];
    }
}