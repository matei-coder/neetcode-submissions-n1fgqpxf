class Solution {
    class Coordonate{
        int x,y;
        int val;
        Coordonate(int x , int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }


    public void islandsAndTreasure(int[][] grid) {
        int inf = 2147483647;
        Queue<Coordonate> q = new LinkedList<>();
        boolean[][] viz = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) q.add(new Coordonate(i , j , 0));
            }
        }


        while(!q.isEmpty()){
            Coordonate curr = q.poll();
            if(curr.x<0||
            curr.x>=grid.length||
            curr.y<0||curr.y>=grid[0].length||
            viz[curr.x][curr.y]==true||grid[curr.x][curr.y]==-1) continue;

            grid[curr.x][curr.y] = curr.val;
            viz[curr.x][curr.y]=true;
            q.add(new Coordonate(curr.x+1 , curr.y , curr.val+1));
            q.add(new Coordonate(curr.x-1 , curr.y , curr.val+1));
            q.add(new Coordonate(curr.x, curr.y+1 , curr.val+1));
            q.add(new Coordonate(curr.x , curr.y-1 , curr.val+1));




        }
    }
}
