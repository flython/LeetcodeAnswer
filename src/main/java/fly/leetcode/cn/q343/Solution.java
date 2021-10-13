package fly.leetcode.cn.q343;

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int cur = j * Math.max(dp[i-j-1],i-j);
                max = Math.max(cur,max);
            }
            dp[i-1] = max;
        }
        return dp[n-1];
    }
}
