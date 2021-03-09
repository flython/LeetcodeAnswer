package fly.leetcode.cn.q53;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int maxSubArray(int[] nums){
        return maxSubArray0(nums)[0];
    }
    public int[] maxSubArray0(int[] nums){
        int len = nums.length;
        int last = nums[len-1];
        if (len < 2){
            //退出末尾时负载为末尾值
            return new int[]{last,last};
        }

        int[] max_cap = maxSubArray0(Arrays.copyOf(nums, len - 1));
        int subMax = max_cap[0];
        // 最大值到末尾的和（前置负载）
        int subCap = max_cap[1];// 不用比较
        // 如果负载已经小于0，可以干脆重新开始计算负载
        subCap = subCap < 0?0:subCap;
        int capSum = subCap + last;

        int max = Math.max(last,Math.max(subMax,capSum));

        if (max == last){
            return new int[]{last,last};
        } else if (max == capSum){
            return new int[]{capSum,capSum};
        } else {
            return new int[]{subMax,capSum};
        }

    }
}
