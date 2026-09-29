class Solution {


    int[] dx = {-1 , 1 , 0 , 0};
    int[] dy = {0 , 0 , 1 , -1};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Integer[][] dp = new Integer[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans , dfs( i , j , matrix , dp));
            }
        }

        return ans;

    }

    private int dfs(int x , int y , int[][] matrix , Integer[][] dp){
        int n = matrix.length;
        int m = matrix[0].length;
        int maxim = 0;

        if(dp[x][y] != null) return dp[x][y];


        for(int i=0;i<dx.length;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX>=0 && newY >=0 && newX<n && newY <m
            && matrix[newX][newY] > matrix[x][y]){
                maxim = Math.max(maxim , dfs(newX , newY , matrix , dp));
            }
        }
        dp[x][y] = 1+maxim;


        return 1+ maxim;
    }
}
