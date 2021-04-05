package fly.leetcode.cn.q80;

/**
 * 由于能允许有两个相同的存在，而数组又是升序的，那必然可以断言
 *      对于第 n 个数，必然大于 第 n-2 个数
 *
 *  于是遍历数组（双指针)，把所有符合以上条件的数放到第n位上（快指针指向又符合的放到慢指针位置上）
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        //遍历数组，找到与大于当前填充位的
        for (int fast : nums) {
            if (slow<2 || fast > nums[slow-2]){
                nums[slow++] = fast;
            }
        }
        //当放完最后一个符合要求的数的时候，slow等于最后index+1，也就是等于新数组长度
        return slow;
    }
}
