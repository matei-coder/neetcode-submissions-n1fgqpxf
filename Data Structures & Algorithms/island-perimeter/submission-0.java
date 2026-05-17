class Solution {
    public int islandPerimeter(int[][] grid) {
        int s = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                s+= cate(i , j , grid);
                System.out.print(s+ " ");
            }
            System.out.println("");
        }
        return s;
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