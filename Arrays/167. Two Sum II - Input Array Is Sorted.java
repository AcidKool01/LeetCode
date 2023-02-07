
// #sed_lyfe :')

class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int res[] = new int[2];
        for (int i=0; i<n; i++) {
            int left=0, right=n-1;
            int k = target-arr[i];
            while(left<=right) {
                int mid = (left+right)/2;
                if(arr[mid]==k && mid!=i) {
                    res[0] = i+1;
                    res[1] = mid+1;
                    Arrays.sort(res);
                    return res;
                } else if(arr[mid] < k) {
                    left=mid+1;
                } else {
                    right=mid-1;
                }
            }
        }
        return res;
    }
}

// :')

public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target) r--;
        else l++;
    }
    return new int[]{l + 1, r + 1};
}