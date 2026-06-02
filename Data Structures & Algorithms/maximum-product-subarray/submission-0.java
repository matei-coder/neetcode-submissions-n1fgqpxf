class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int maxim = nums[0];
        int minim = nums[0];
        int rezultat = nums[0]; 

        for (int i = 1; i < n; i++) {
            int curent = nums[i];
            int temp_maxim = maxim; 
            maxim = Math.max(curent, Math.max(temp_maxim * curent, minim * curent));
            minim = Math.min(curent, Math.min(temp_maxim * curent, minim * curent));
            rezultat = Math.max(rezultat, maxim);
        }

        return rezultat;
    }
}