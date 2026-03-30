class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int apamx=0;
        while(i<j){
            apamx=Math.max(apamx , Math.min(heights[i],heights[j])*Math.abs(i-j));
            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            }

        }
        return apamx;
    }
}
