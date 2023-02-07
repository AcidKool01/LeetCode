class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int []> output = new ArrayList();
        int row = land.length;
        int col = land[0].length;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(land[i][j] == 1)
                {
                    int[] result = {row+1,col+1,-1,-1};
                    result = dfs(land,row,col,i,j,result);
                    output.add(result);
                }
            }
        }
        
        return output.toArray(new int[0][]);
    }
    
    private int[] dfs(int[][] land,int row,int col,int i,int j,int[] result)
    { 
        if(i < row && j < col)
        {
            if(land[i][j] == 1)
            {
                result[0] = Math.min(result[0],i);
                result[1] = Math.min(result[1],j);
                result[2] = Math.max(result[2],i);
                result[3] = Math.max(result[3],j);
                land[i][j] = -1;
                result = dfs(land,row,col,i+1,j,result);
                result = dfs(land,row,col,i,j+1,result);   
            }
        }
        return result;
    }
}