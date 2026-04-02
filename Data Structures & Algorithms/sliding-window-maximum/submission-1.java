class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] rasp = new int[nums.length-k+1];
        int it=0;
        for(int i=0;i+k<=nums.length;i++){
            int maxim = -10005;
            for(int j=i;j<i+k;j++){
                maxim = Math.max(nums[j], maxim);
            }
            rasp[it++] = maxim;
        }

        return rasp;

    }
}
