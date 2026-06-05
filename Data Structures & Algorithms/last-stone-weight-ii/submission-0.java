class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) sum += s;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // Can we reach each possible sum using a subset of stones?
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // Find the largest achievable sum ≤ total/2
        for (int j = target; j >= 0; j--) {
            if (dp[j]) return sum - 2 * j; // group1=j, group2=sum-j
        }

        return sum;
    }
}