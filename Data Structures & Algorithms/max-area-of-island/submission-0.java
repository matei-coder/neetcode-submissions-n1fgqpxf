class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxans = 0 ; 
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                maxans = Math.max(areadfs(i , j , grid), maxans);
            }
        }
        return maxans;
    }

    public int areadfs(int x , int y , int[][] grid ){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0) return 0;
        grid[x][y] = 0;
        return 1+areadfs(x+1 , y , grid)+
        areadfs(x-1, y , grid) + 
        areadfs(x , y+1 , grid)+
        areadfs(x , y-1 , grid);
    }
}
