class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        
        while(low<=high) {
            int mid = (low+high)/2;
            int count=0, maxNum = low;
            
            for (int i=0, j=m-1; i<n; i++) {
                while(j>=0 && matrix[i][j] > mid) j--;
                
                if(j>=0) {
                    count+=j+1;
                    maxNum = Math.max(matrix[i][j], maxNum);
                } else {
                    break;
                }
            }
            
            if(count==k) return maxNum;
            else if(count>k) high = mid-1;
            else low = mid+1;
        }
        
        return low;
    }
}