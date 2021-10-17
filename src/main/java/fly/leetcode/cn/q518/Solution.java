package fly.leetcode.cn.q518;

/**
 * 完全背包：
 * dp数组定义，dp数组中的值代表包含当前硬币后，在下标值下的最大零钱组合数
 * 初始化，因为假如总数为0，组合数永远都是1（什么都不选）
 * 递推公式，每一个新总值，可以不选，可以选1个，可以选2个...直到选不了，所以每一个新的dp[i] = 前面所有可选值的和（从尾部开始遍历），
 *          但换个思路，我可以从头部开始遍历，这样就剩下重复计算前面的可选值和，每次新计算时只需要加上刚刚计算过的那个dp[i-cons[j]]就好了
 */
class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}