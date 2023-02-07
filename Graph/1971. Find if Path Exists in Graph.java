
// Brute-Force, wherein checking through everynode which is connected with start and then marking them in "used" boolean array.
// Faster than BFS/DFS..

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] used = new boolean[n];
        used[start] = true;
        boolean newUsedFound = true;
        while (!used[end] && newUsedFound) {
            newUsedFound = false;
            for (int i = edges.length - 1; i >= 0; i--) {
                if (used[edges[i][0]]) {
                    if (!used[edges[i][1]])  newUsedFound = used[edges[i][1]] = true;
                } else if (used[edges[i][1]]) {
                    newUsedFound = used[edges[i][0]] = true;
                }
            }
        }
        return used[end];
    }
}

// BFS Approach

class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int start, int end) {
        unordered_map<int,vector<int>> graph; 
        for(auto e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n,0);        
        queue<int> q;
        q.push(start);
        visited[start] = 1; 
        while(!q.empty()) {
            int curr = q.front();
            q.pop();
            if(curr == end)
                return 1; 
            for(auto &node : graph[curr]){
                if(!visited[node]){
                    visited[node] = 1; 
                    q.push(node);
                }
            }
        }
        
        return false;
    }
};