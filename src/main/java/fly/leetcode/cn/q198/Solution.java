package fly.leetcode.cn.q198;

/**
 * 动态规划，内存优化版
 */
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return nums[0];
        } else if (length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] sum = new int[2];
        sum[0] = nums[0];
        sum[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < length; i++) {
            int val = Math.max(sum[0]+nums[i],sum[1]);
            sum[0] = sum[1];
            sum[1] = val;
        }
        return sum[1];
    }
}