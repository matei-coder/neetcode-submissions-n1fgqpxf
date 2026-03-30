class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(k==0) return;
        int[] noi = new int[nums.length-k];
        for(int i=0;i<nums.length-k;i++){
            noi[i]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=nums[nums.length-k+i];
        }
        int j=0;
        for(int i=k;i<nums.length;i++){

            nums[i]=noi[j++];
        }

       

    }

    public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}


}