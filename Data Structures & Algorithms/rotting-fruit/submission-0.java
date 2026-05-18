class Solution {
    class Coordonate{
        int x, y, val;
        Coordonate(int x , int y , int val){
            this.x = x;
            this.y = y;
            this.val =val;
        }
    }



    public int orangesRotting(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        boolean viz[][] = new boolean[n][m];
        Queue<Coordonate> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) q.add(new Coordonate(i , j , 0));
            }
        }

        while(!q.isEmpty()){
            Coordonate curr = q.poll();
            if(curr.x<0||curr.x>=n||
            curr.y<0||curr.y>=m||
            viz[curr.x][curr.y]==true||grid[curr.x][curr.y]==0) continue;

            viz[curr.x][curr.y] = true;
            grid[curr.x][curr.y] = curr.val;

            q.add(new Coordonate(curr.x+1 , curr.y , curr.val+1));
            q.add(new Coordonate(curr.x-1 , curr.y , curr.val+1));
            q.add(new Coordonate(curr.x , curr.y+1 , curr.val+1));
            q.add(new Coordonate(curr.x , curr.y-1 , curr.val+1));



        }
        int maxtimp = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grid[i][j]+" ");
                if(grid[i][j]>maxtimp) maxtimp = grid[i][j];
                if(grid[i][j]==1&&viz[i][j]==false) return -1; 
            }
            System.out.println("");
        }
        return maxtimp;





    }
}
