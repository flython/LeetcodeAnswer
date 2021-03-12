package fly.leetcode.cn.q121;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 分析： 1. 目标 找到数组里面的最大后置元素与前置元素的最大差
 *
 */
class Solution {
    public int maxProfit(int[] prices) {
        int hisMaxIc = -1;
        int min = Integer.MAX_VALUE-10;
        int max = -1;

        for (int price : prices) {
            max = Math.max(max,price);
            if (min > price){
                hisMaxIc = Math.max(max-min,hisMaxIc);
                min = price;
                max = -1;
            }
        }

        hisMaxIc = Math.max(max-min,hisMaxIc);
        return Math.max(hisMaxIc,0);

    }
}