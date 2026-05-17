class Solution {


    List<String> ans = new ArrayList<>();
    
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isLast = false;
        String word = null;
    }
    TrieNode root = new TrieNode();


    public void find(int x, int y , char[][] board  , TrieNode curr , boolean[][] viz){
        int n = board.length;
        int m = board[0].length;    
        

        if(x>=n||y>=m||x<0||y<0|| viz[x][y]) return;
        

        int idx = board[x][y] -'a';
        if(curr.children[idx]==null) return;
        curr = curr.children[idx];

        if(curr.isLast ==true){
            ans.add(curr.word);
            curr.isLast = false;
        }

        
            viz[x][y] = true;
            find(x+1 , y , board , curr , viz);
            find(x , y+1 , board , curr , viz);
            find(x-1 , y , board , curr , viz );
            find(x , y-1 , board , curr , viz);
            viz[x][y] = false;
        


    }


    public void addToTrie(String word){
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null) curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.isLast= true;
        curr.word = word;
    }




    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0] .length;
        for(String word : words) addToTrie(word);
        boolean[][] viz = new boolean[n][m];
        //TrieNode curr = root;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                find(i , j , board , root , viz);
            }
        }
        return ans;


        


    }
}
