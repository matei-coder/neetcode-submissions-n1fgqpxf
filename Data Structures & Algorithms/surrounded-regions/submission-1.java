class Solution {
    class Coordonate{
        int x , y;
        Coordonate(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }


    public void solve(char[][] board) {

        int[] dx = {1,-1 , 0, 0};
        int[] dy = {0,0 , 1, -1};


        
        int n=board.length , m=board[0].length;
        boolean[][] viz = new boolean[n][m];
        Queue<Coordonate> q =new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||j==0||i==n-1||j==m-1)&&
                board[i][j]=='O') 
                q.add(new Coordonate(i , j));
            }
        }


        while(!q.isEmpty()){
            Coordonate curr = q.poll();
            if(curr.x<0||curr.y>=m||curr.x>=n||curr.y<0
            ||board[curr.x][curr.y]=='X'||viz[curr.x][curr.y]==true) continue;
            viz[curr.x][curr.y] = true;


            for(int i=0;i<4;i++){
                q.add(new Coordonate(curr.x+dx[i] , curr.y+dy[i]));
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = 'X';
                if(viz[i][j])board[i][j] = 'O';


            }}


    }
}
