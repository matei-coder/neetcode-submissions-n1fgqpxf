class Solution {

    int[] dx = {0 , 0 , -1 , 1};
    int[] dy = {1 , -1 , 0 , 0};


    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int max =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max , grid[i][j]);
            }
        }
        int ans=-1;
        int l=0 , r=max;
        while(l<=r){
            boolean[][] viz = new boolean[n][n];
            int m = (r+l)/2;
            boolean bol = bfs(grid , m , viz);
            System.out.println(m+" "+bol);
            if(bol){
                ans =m;
                r=m-1;
            }
            else{
                
                l=m+1;
            }
        }

        return ans;




    }


    public boolean bfs(int[][] grid ,int max , boolean[][] viz){
        if(grid[0][0]>max) return false;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0 , 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==n-1&&curr[1]==n-1) return true;
            if(viz[curr[0]][curr[1]]==true) continue;
            viz[curr[0]][curr[1]]=true;

            for(int i=0;i<4;i++){
                int newx = curr[0]+dx[i];
                int newy = curr[1]+dy[i];

                if(newx>=n||newy>=n||newy<0||newx<0) continue;
                if(grid[newx][newy]>max) continue;
                q.add(new int[]{newx , newy});
            }
        }

        return false;






        
    }
}
