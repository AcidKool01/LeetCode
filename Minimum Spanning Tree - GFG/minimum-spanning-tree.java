//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


class DisjointSet {
    private int[] parent;
    private int[] size;
    private int n;

    DisjointSet(int n) {
        this.n = n;
        initialize(n);
    }

    public void initialize(int n) {
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++) { parent[i] = i; size[i] = 0; }
    }

    public int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    public int pathCompressionFind(int x) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);

        if(x_rep ==  y_rep) return;

        if(size[x_rep] < size[y_rep]) { parent[x_rep] = y_rep; size[y_rep] = size[y_rep] + size[x_rep]; }
        else { parent[y_rep] = x_rep; size[x_rep] = size[y_rep] + size[x_rep]; }
    }
    
}

class Edge implements Comparable<Edge> {
    int u;
    int v; 
    int cost;
    
    Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
    
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

class Solution{
    
    static List<Edge> buildGraph(int[][] edges) {
        int n = edges.length;
        List<Edge> graph = new ArrayList<Edge>();
        
        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int cost = e[2];
            
            graph.add(new Edge(u, v, cost));
        }
        
        return graph;
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    DisjointSet ds = new DisjointSet(V);
	    List<Edge> graph = buildGraph(edges);
	    int weight = 0;
	    Collections.sort(graph);
	    
	    for(Edge e: graph) {
	        int u = e.u;
	        int v = e.v;
	        int cost = e.cost;
	        
	        if(ds.find(u) != ds.find(v)) {
	            weight += cost;
	            ds.union(u, v);
	        }
	    }
	    
	    return weight;
	}
}