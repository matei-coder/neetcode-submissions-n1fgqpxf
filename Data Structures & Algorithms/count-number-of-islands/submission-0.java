class Solution {
    int ans = 0;

    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] viz = new int[n][m];
        int k=0;
        for(int i =0;i< n ;i++){
            for(int j=0;j<m;j++){
                if(viz[i][j] == 0 && grid[i][j] == '1') 
                    dfs(i , j , grid , viz , ++k);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(viz[i][j]+" ");
            }
            System.out.println("");
        }

        return k;

    }
    public void dfs(int x , int y , char[][] grid,  int[][] viz , int k){
        char c = grid[x][y];
        if(c == '0' || viz[x][y]!=0){
            return;
        }
       
            viz[x][y] = k;
            if(x-1>=0) dfs(x-1, y , grid , viz , k);
            if(x+1<grid.length) dfs(x+1, y , grid , viz , k);
            if(y-1>=0) dfs(x, y-1 , grid , viz , k);
            if(y+1<grid[0].length) dfs(x, y+1 , grid , viz , k);

        

    }
}
