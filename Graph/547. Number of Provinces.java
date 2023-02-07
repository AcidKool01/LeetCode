
// Similar to no. of connected component in an undirected graph...

class Solution {
    public int findCircleNum(int[][] M) {
        int count = 0;
        for (int i=0; i<M.length; i++)
            if (M[i][i] == 1) { count++; BFS(i, M); }
        return count;
    }

    public void BFS(int student, int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(student);
        while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int i=0;i<queueSize;i++) {
                int j = queue.poll();
                M[j][j] = 2; // marks as visited
                for (int k=0; k<M[0].length; k++) 
                    if (M[j][k] == 1 && M[k][k] == 1) queue.add(k);
            }
        }
    }
}