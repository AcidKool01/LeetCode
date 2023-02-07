class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length, snowBallSize = 0;
        for (int i=0; i<n; i++) {
            if(arr[i]==0) {
                snowBallSize++;
            } else if(snowBallSize>0) {
                int x = arr[i];
                arr[i]=0;
                arr[i-snowBallSize] = x;
            }
        }  
    }
}