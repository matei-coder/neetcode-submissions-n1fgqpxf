class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, n2 = matrix[0].length;
        int l=0, r=n*n2-1;
        while(l<=r){
            int m=(r-l)/2+l;
            int mi = m/n2, mj= Math.max(0,(m)%n2);
            if(matrix[mi][mj]==target) return true;
            else if(matrix[mi][mj]>target) r=m-1;
            else l=m+1;
        }

        return false;
    }
}
