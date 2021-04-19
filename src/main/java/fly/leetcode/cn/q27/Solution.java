package fly.leetcode.cn.q27;

/**
 * 27. 移除元素
 *
 * 今天的题目依然是那么简单
 *
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int current = 0;
        for (int num : nums) {
            if (num != val){
                nums[current++] = num;
            }
        }
        return current;
    }
}
