class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        int k = 0;
        for(int j=0;j<n;j++){
            for(int i = n-1;i>=0;i--){
                ans[k/n][k%n] = matrix[i][j];
                k++;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
}
