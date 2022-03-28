package fly.leetcode.cn.q746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        //1. 状态转移：sum[i] = cost + min(sum[i-1],sum[i-2])
        for (int i = 2; i < length; i++) {
            cost[i] = cost[i] + Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[length-1],cost[length-2]);
    }
}
