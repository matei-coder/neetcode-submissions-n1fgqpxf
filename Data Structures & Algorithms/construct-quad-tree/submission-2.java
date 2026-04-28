/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return creategraph(grid , 0 , 0 , grid.length , grid.length);
    }
    public int isGrid(int[][] grid , int istart, int jstart,int iend , int jend ){
        int f = grid[istart][jstart];
        for(int i=istart ; i<iend ;i++){
            for(int j=jstart;j<jend;j++){
                if(grid[i][j]!=f) return -1;
            }
        }
        return f;
    }
    public Node creategraph(int[][] grid , int is , int js , int iF , int jf){
        int ifisgrid = isGrid(grid , is , js , iF , jf);
        if(ifisgrid!=-1){
            boolean gridval = (ifisgrid==0) ? false : true ;
            return new Node(gridval , true);
        }
        else{
            int imid = (is + iF) / 2;  // ← mijlocul real între is și iF
            int jmid = (js + jf) / 2;  // ← mijlocul real între js și jF

            Node topleft     = creategraph(grid, is,   js,   imid, jmid);
            Node topright    = creategraph(grid, is,   jmid, imid, jf);
            Node bottomleft  = creategraph(grid, imid, js,   iF,   jmid);
            Node bottomright = creategraph(grid, imid, jmid, iF,   jf);

            return new Node( false , false , topleft , topright , bottomleft , bottomright);
        }
    }



}