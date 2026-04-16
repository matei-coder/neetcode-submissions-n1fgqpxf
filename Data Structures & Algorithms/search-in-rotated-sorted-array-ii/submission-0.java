class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;

            // Handle duplicates: skip the pointers if we can't determine direction
            if (nums[l] == nums[m] && nums[r] == nums[m]) {
                l++;
                r--;
            } 
            // Left side is sorted
            else if (nums[l] <= nums[m]) {
                // If target is within the sorted left range
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } 
            // Right side is sorted
            else {
                // If target is within the sorted right range
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}