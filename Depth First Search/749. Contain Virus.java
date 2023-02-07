class Region {
    Set<Integer> infected = new HashSet<>();
    Set<Integer> uninfectedNeighbours = new HashSet();
    int wallsNeeded = 0;
}

class Solution {  
    public int containVirus(int[][] isInfected) {
        int n = isInfected.length, m = isInfected[0].length;
        PriorityQueue<Region> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.uninfectedNeighbours.size(), a.uninfectedNeighbours.size()));
        int res = 0, phase = 1;
        addRegions(isInfected, phase, n, m, pq);
        while(!pq.isEmpty()) {
            Region curr = pq.poll();
            res += curr.wallsNeeded;
            for (int cell : curr.infected) {
                isInfected[cell / m][cell % m] = -1;
            }
            phase++;
        
            while (!pq.isEmpty()) {
                Region region = pq.poll();
                for (int cell : region.uninfectedNeighbours) {
                    isInfected[cell / m][cell % m] = phase;
                }
            }
        
            addRegions(isInfected, phase, n, m, pq);
        }
        return res;
    }
    
    private void addRegions (int[][] isInfected, int phase, int n, int m, PriorityQueue<Region> pq) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(isInfected[i][j]==phase) {
                    Region region = new Region();
                    dfs(isInfected, i, j, n, m, phase, region);
                    if(!region.uninfectedNeighbours.isEmpty()) pq.offer(region);
                }
            }
        }
    }
    
    private void dfs (int[][] isInfected, int i, int j, int n, int m, int phase, Region region) {
        if (i<0 || i>=n || j<0 || j>=m || isInfected[i][j] == -1 || isInfected[i][j] > phase) {
            return;
        }
        
        if (isInfected[i][j] == 0) {
            region.uninfectedNeighbours.add(i * m + j);
            region.wallsNeeded++;
            return;
        }
        
        isInfected[i][j]++;
        region.infected.add(i * m + j);
        
        dfs(isInfected, i + 1, j, n, m, phase, region);
        dfs(isInfected, i - 1, j, n, m, phase, region);
        dfs(isInfected, i, j + 1, n, m, phase, region);
        dfs(isInfected, i, j - 1, n, m, phase, region);
    }
}