class Solution {
    
    private void reverseArray (int[] arr, int left, int right) {
        while(left<right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }
    
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList();
        int n = grid.length, m = grid[0].length;
        int arrSize = n*m;
        int[] arrGrid = new int[arrSize];
        int f=0;
        k = k%arrSize;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                arrGrid[f++] = grid[i][j];
            }
        }
        
        reverseArray(arrGrid, 0, arrSize-1);
        reverseArray(arrGrid, 0, k-1);
        reverseArray(arrGrid, k, arrSize-1);
         
        f=0;
        
        for (int i=0; i<n; i++) {
            List<Integer> temp = new ArrayList();
            for (int j=0; j<m; j++) {
                temp.add(arrGrid[f++]);
            }
            res.add(temp);
        }
        
        return res;
    }
}