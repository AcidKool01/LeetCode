
// Greedy Approach

class Solution {    
    public int jump(int[] nums) {
        int jump = 0;
		int left = 0;
		int right = 0;

		while (right < nums.length - 1) {
			int max = 0;
			
			for (int i = left; i <= right; i++) {
				max = Math.max(nums[i] + i, max);
			}
			
			left = right + 1;
			right = max;
			jump++;
		}
		return jump;
    }
}

// DP Approach

public int topDownDp(int[] nums) {
	return topDownRec(nums, 0, new int[nums.length]);
}

	private int topDownRec(int[] nums, int start, int[] output) {
		if (start >= nums.length - 1) {
			return 0;
		}
		if (output[start] != 0) {
			return output[start];
		}
		int min = 10001; // max possible jump is 10^4
		for (int i = start + 1; i <= nums[start] + start; i++) {
			min = Math.min(min, 1 + topDownRec(nums, i, output));
		}
		output[start] = min;
		return min;
	}