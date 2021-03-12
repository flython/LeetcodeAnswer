package fly.leetcode.cn.q121;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 分析： 1. 目标 找到数组里面的最大后置元素与前置元素的最大差
 * 参考网上的答案优化出来的，基本思路是一样的，少用了一个变量，多做了几次计算，看起来写得更简单了
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int income = 0;
        for (int price : prices) {
            income = Math.max(income,price-min);
            min = Math.min(min,price);
        }
        return income;
    }
}