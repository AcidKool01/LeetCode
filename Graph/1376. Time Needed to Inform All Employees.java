
// TLE :")

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int minutes = 0;
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{headID, informTime[headID]});
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            for (int i=0; i<qSize; i++) {
                int[] x = q.poll();             
                minutes = Math.max(minutes, x[1]);                
                for(int j=0; j<n; j++) {
                    if(manager[j]==x[0]) {
                        q.add(new int[]{j, x[1] + informTime[j]});
                    }
                }
            }     
        }
        
        return minutes;
    }
}

// converted to adjaceny list..obviously upper one was naive.. like wtf were you thinking ? like traversing array every time ? :")

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int minutes = 0;
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{headID, informTime[headID]});
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i=0; i<n; i++) {
            if(manager[i]>=0) adjList.get(manager[i]).add(i);
        }
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            for (int i=0; i<qSize; i++) {
                int[] x = q.poll();             
                minutes = Math.max(minutes, x[1]);                
                for(int j: adjList.get(x[0])) {  
                    q.add(new int[]{j, x[1] + informTime[j]});          
                }
            }     
        }
        
        return minutes;
    }
}