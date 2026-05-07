class Solution {
    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    sb.append(board[i][j]);
                    backtrack(word , board , sb , i , j , 1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

        return ans;

    }
    public void backtrack( String word , char[][] board , StringBuilder sb , int i , int j , int k){
        //System.out.println(sb.toString());

        if(ans == true) return ;
        if(sb.length()==word.length()){
            if(sb.toString().equals(word)){
                //System.out.println(sb);
                ans = true;
            }
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        char rasp = word.charAt(k);
        if(i>0&&board[i-1][j]==rasp){
            sb.append(board[i-1][j]);
            backtrack(word , board , sb , i-1 , j , k+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(j<board[0].length-1&&board[i][j+1]==rasp){
            sb.append(board[i][j+1]);
            backtrack(word , board , sb , i , j+1 , k+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(i<board.length-1&&board[i+1][j]==rasp){
            sb.append(board[i+1][j]);
            backtrack(word , board , sb , i+1 , j , k+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(j>0&&board[i][j-1]==rasp){
            sb.append(board[i][j-1]);
            backtrack(word , board , sb , i , j-1 , k+1);
            sb.deleteCharAt(sb.length()-1);
        }

        board[i][j]= temp;

        

    }
}
