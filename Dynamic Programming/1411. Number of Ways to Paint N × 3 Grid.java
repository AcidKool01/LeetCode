class Solution {
    public int numOfWays(int n) {
        int mod=(int)1e9+7;
        long dp2=6, dp3=6;
        for(int i=1; i<n; i++){
            long temp2=dp2;
            long temp3=dp3;
            dp2=((temp3*2)%mod+(temp2*3)%mod)%mod;
            dp3=((temp2*2)%mod+(temp3*2)%mod)%mod;
        }
        return (int)(dp2+dp3)%mod;
    }
}