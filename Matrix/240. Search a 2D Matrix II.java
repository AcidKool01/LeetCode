class Solution {
    
//     private int binarySearch(int[] arr, int key) {
//         int low = 0, high = arr.length-1;
//         while(low <= high) {
//             int mid = high - (high-low)/2;
//             if(arr[mid]==key) {
//                 return mid;
//             } else if(arr[mid] > key) {
//                 high = mid -1;
//             } else {
//                 low = mid + 1;
//             }
//         }
//         return -1;
//     }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i=n-1, j=0; i>=0 && j<m; ){
            if(target == matrix[i][j]) return true;
            else if(target > matrix[i][j]) j++;
            else i--;
        }
        return false;
    }
}