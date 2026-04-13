class Solution {
    public int largestRectangleArea(int[] heights) {
        int answer = 0;
        for(int i=0;i<heights.length;i++){
            int minheight = heights[i];
            int l=i, r=i;
            answer = Math.max(answer , minheight*(r-l+1));
            while(l>0&&r<heights.length-1){
                if(heights[l]<heights[l]){
                    l--;
                    minheight =Math.min(minheight , heights[l]);
                }
                else{
                    r++;
                    minheight =Math.min(minheight , heights[r]);

                }
                answer = Math.max(answer , minheight*(r-l+1));
            }
            while(l>0){
                l--;
                minheight =Math.min(minheight , heights[l]);
                answer = Math.max(answer , minheight*(r-l+1));
            }
            while(r<heights.length-1){
                r++;
                minheight =Math.min(minheight , heights[r]);
                answer = Math.max(answer , minheight*(r-l+1));
            }
        }

        return answer;
    }
}
