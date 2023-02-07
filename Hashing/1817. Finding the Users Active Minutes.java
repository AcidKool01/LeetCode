class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int n = logs.length;
        int[] UAV = new int[k];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for(int i=0; i<n; i++) {
            HashSet<Integer> temp = map.getOrDefault(logs[i][0], new HashSet<Integer>());
            temp.add(logs[i][1]);
            map.put(logs[i][0], temp);
        }
        
        for(Map.Entry<Integer, HashSet<Integer>> entry: map.entrySet()) {
            UAV[entry.getValue().size()-1]++;
        }
        return UAV;
    }
}