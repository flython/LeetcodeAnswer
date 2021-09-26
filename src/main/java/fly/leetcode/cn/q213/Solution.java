package fly.leetcode.cn.q213;

/**
 * 解题思路，首先，因为这种机器判定的场景，肯定是会把解控制在可以唯一解的范围内的，所以退火、遗传等高级算法是不需要的
 * 那这道题明显是算法题而不是数据结构题，所以可以考虑 动态规划、贪心、回溯
 *
 * 当我们有一个房子时，偷了他，肯定是最大的
 * 当我们有两个房子时，偷比较大的那个，肯定是最大的
 * 当我们有3个时，偷第三个，则第一第二不能偷，所以最大为v3，不偷第三个，则最大值为max[v1..v2] = max(v1,v2), 最大 = max(max(v1,v2),v3)
 * 当我们有3个以上房子时，如果偷第1个，那么第2和n-1不能偷，所以总价值是 v1 + max[v3..vn-1]
 *                    如果不偷第1个，那么总价值是 0 + max[v2..vn]
 *                    答案为以上两者最大者
 */
/**
 * 动态规划，内存优化版
 */
class Solution {
    public int rob(int[] nums) {
        //特殊情况处理
        int maxN = nums.length-1;
        if (maxN == 0){
            return nums[0];
        } else if (maxN == 1){
            return Math.max(nums[0],nums[1]);
        }

        //保存初始值
        int[] sum = new int[]{nums[0], Math.max(nums[0], nums[1]),nums[1],Math.max(nums[1],nums[2])};

        //从3开始
        for (int i = 2; i <= maxN; i++) {
            // sum1，算第一个的情况
            int val;
            if (i!= maxN){
                val = Math.max(sum[0]+nums[i],sum[1]);
                sum[0] = sum[1];
                sum[1] = val;
            }
            //sum2， 不算第一个的情况
            if (i!=2){
                val = Math.max(sum[2]+nums[i],sum[3]);
                sum[2] = sum[3];
                sum[3] = val;
            }
        }

        return Math.max(sum[1], sum[3]);
    }
}