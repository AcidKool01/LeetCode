class Solution {
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        
        while(mid<=high) {
            if(nums[mid]==0) {
                swap(nums, low, mid);
                low++; mid++;
            } else if(nums[mid]==1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}