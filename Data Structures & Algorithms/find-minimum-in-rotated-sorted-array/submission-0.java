class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] <= nums[r]) {
                r = m;        // minimul e în stânga, inclusiv m
            } else {
                l = m + 1;    // minimul e în dreapta, m exclus
            }
        }
        return nums[l];
    }
}