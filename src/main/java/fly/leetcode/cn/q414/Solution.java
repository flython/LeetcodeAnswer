package fly.leetcode.cn.q414;

import java.util.stream.IntStream;

/**
 * java快乐解法
 */
class Solution {
    public int thirdMax(int[] nums) {
        int[] ints = IntStream.of(nums).distinct().sorted().toArray();
        return ints[ints.length>=3?ints.length-3:ints.length-1];
    }
}