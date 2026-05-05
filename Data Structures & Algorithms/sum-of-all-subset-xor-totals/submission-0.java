class Solution {

    int sum = 0;
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        boolean [] tries = new boolean[n];
        for(int i=0;i<n;i++) tries[i] = false;
        backtrack(tries , 0 , false , nums);
        backtrack(tries , 0 , true , nums);
        return sum;

    }

    public void backtrack(boolean tries[] , int i , boolean on , int nums[]){
        tries[i] = on;
        int de =0;
        if(i==tries.length-1)
        for(int j=0;j<tries.length;j++){
            if(tries[j]==true) de = de^nums[j];
        }
        sum+=de;
        if(i+1<tries.length){
            backtrack(tries , i+1 , true , nums);
            backtrack(tries , i+1 , false , nums);
        }
    }
}