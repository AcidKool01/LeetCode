

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null) return mat; 
        int rowLen = mat.length;
        int colLen = mat[0].length;
        boolean visited[][] = new boolean[rowLen][colLen];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int directions[][] ={{1,0},{-1,0},{0,-1},{0,1}};
        int level = 0;
        
        for(int i=0; i<rowLen; i++){
            for(int j =0; j<colLen; j++){
                if(mat[i][j] == 0)
                    q.add(new Pair<Integer, Integer>(i,j));
                else
                    mat[i][j] = -1;
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                Pair<Integer, Integer> cur = q.poll();
                for(int dir[] : directions){
                    int r = cur.getKey() + dir[0];
                    int c = cur.getValue() + dir[1];
                    //Insert in queue only the only marked wih -1 and make it true 
                    if(r>=0 && r<rowLen && c>=0 && c<colLen && mat[r][c]==-1 && !visited[r][c] ){
                        visited[r][c] = true;
                        q.add(new Pair<Integer, Integer>(r,c)); // for next time iteration with increase level 
                    }
                }
                mat[cur.getKey()][cur.getValue()] = level; //once size is over, we mark all the elements initially with level 0
                //next time level increases
            }
            level++; // after size is over, level is increased for next processing
        }
        return mat;
    }
}



// DP beh******

class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;
    }
}