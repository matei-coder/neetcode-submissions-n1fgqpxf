class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int[] dp = new int[n];
        ans[0] = 0;
        for(int i=1;i<=n;i++){
            ans[i] = 1+ans[i&(i-1)];
        }

        return ans;
    }
}
