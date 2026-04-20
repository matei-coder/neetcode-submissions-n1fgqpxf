class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int first = binAsc(mountainArr, 0, peak, target);
        if (first != -1) return first;
        return binDsc(mountainArr, peak + 1, mountainArr.length() - 1, target);
    }

    public static int findPeak(MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {                                    // ✅ l < r
            int m = (r - l) / 2 + l;
            if (mountainArr.get(m) < mountainArr.get(m + 1)) l = m + 1;
            else r = m;                                    // ✅ r = m
        }
        return l;
    }

    public static int binAsc(MountainArray mountainArr, int l, int r, int target) {
        while (l <= r) {                                   // ✅ l <= r
            int m = (r - l) / 2 + l;
            int el = mountainArr.get(m);
            if (el == target) return m;
            else if (el > target) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public static int binDsc(MountainArray mountainArr, int l, int r, int target) {
        while (l <= r) {
            int m = (r - l) / 2 + l;
            int el = mountainArr.get(m);
            if (el == target) return m;
            else if (el > target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}