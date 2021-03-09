package fly.leetcode.cn.q53;

import java.util.Arrays;

/**
 * 思路其实跟递归是一样的，只不过为什么我没有想到循环更简单呢
 */
class SolutionLoop extends Solution{

    @Override
    public int maxSubArray(int[] nums){
        // 跟第一种解法的cap是一样的，用来记录前置最优解到最新位置的负载和
        // = subCap
        int sum = 0;
        // 前置最优解 = subMax
        int res = nums[0];

        // =last
        for (int num : nums) {
            //一样是把caps 加到 last 上，如果小于0就直接取last
            if (sum < 0){
                sum = num;
            } else {
                sum+= num;
            }
            res = Math.max(res,sum);
        }

        return res;
    }

}
