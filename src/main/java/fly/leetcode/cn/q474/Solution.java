package fly.leetcode.cn.q474;

/**
 * 双维度 01背包
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int oNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    oNum++;
                }
            }
            int iNum = str.length()-oNum;

            //小于oNum的会超界，所以不用计算
            for (int o = m; o >= oNum; o--) {
                for (int i = n; i >= iNum; i--) {
                    dp[o][i] = Math.max(dp[o][i],dp[o-oNum][i-iNum]+1);
                }
            }
        }
        return dp[m][n];
    }
}
