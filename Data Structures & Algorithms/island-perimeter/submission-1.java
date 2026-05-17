class Solution {
    int s = 0;
    public int islandPerimeter(int[][] grid) {
        boolean gasit = false;
        for(int i=0;i<grid.length;i++){
            if(gasit) break;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(i , j , grid);
                    gasit = true;
                    break;
                }
            }
        }
        
        return s;
    }

    public void dfs(int x, int y , int[][] grid){
        s+=cate(x , y , grid);
        grid[x][y] = -1;
        if(x+1<grid.length && grid[x+1][y]==1) dfs(x+1 , y , grid);
        if(y+1<grid[0].length && grid[x][y+1]==1) dfs(x , y+1 , grid);
        if(x-1>=0 && grid[x-1][y]==1) dfs(x-1 , y , grid);
        if(y-1>=0 && grid[x][y-1]==1) dfs(x , y-1 , grid);

    }


    public int cate (int x, int y , int[][] grid){
        if(grid[x][y]==0) return 0;
        int s = 0;
        if(x-1<0||grid[x-1][y]==0) s++;
        if(y-1<0||grid[x][y-1]==0)s++;
        if(x+1>=grid.length||grid[x+1][y]==0) s++;
        if(y+1>=grid[0].length||grid[x][y+1]==0) s++;

        return s;
    }
}