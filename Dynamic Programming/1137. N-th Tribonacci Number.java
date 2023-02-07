class Solution {
    public int tribonacci(int n) {
        if(n==0) {
            return 0;
        } 
        
        if(n==1 || n==2) {
            return 1;
        }
        
        ArrayList<Integer> dp = new ArrayList<>(n+1);
        for (int i=0; i<=n; i++) {
            dp.add(0);
        }
        dp.set(1, 1);
        dp.set(2, 1);
        dp.set(3, 2);
        
        for (int i=4; i<=n; i++) {
            dp.set(i, dp.get(i-1) + dp.get(i-2) + dp.get(i-3));
        }
        
        return dp.get(n);
    }
}