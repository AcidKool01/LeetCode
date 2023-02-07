class Solution {
    public int minCost(String colors, int[] cost) {
        int n = colors.length();
        int result = 0;
        for (int i=1; i<n; i++) {
            if (colors.charAt(i) == colors.charAt(i-1)) {
                result = result + Math.min(cost[i], cost[i-1]);
                cost[i] = Math.max(cost[i], cost[i-1]);
            }
        }
        return result;
    }
}