package fly.leetcode.cn.q456;

import java.util.BitSet;
import java.util.LinkedList;

/**
 * 怎么感觉是动态规划呢。
 * 进阶思考：如何把所有子串找出来（这应该就是动态规划可以做的）
 * 分析
 *      1 首先小于3的直接false
 *      2 两个变量记录着局部最小值和最大值范围，还有全局最小值
 *      3 每一个新值，先判断符不符合范围，如果不符合，小于最小值更新全局最小值
 *      4 大于最大值 使用全局最小值更新局部最小值，当前值更新最大值
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3){
            return false;
        }

        LinkedList<int[][]> list = new LinkedList<>();

        int partMin = nums[0];
        int max = partMin;
        int mostMin = partMin;

        for (int i = 1; i < nums.length; i++) {
            if (bitSet.get(nums[i] + 1_000_000_000)){
                return true;
            }

            if (nums[i] < mostMin){
                mostMin = nums[i];
            } else if (nums[i] - mostMin > 1){
                bitSet.set(mostMin+1_000_000_001,nums[i] + 999_999_999);
            }
        }

        return false;
    }
}
