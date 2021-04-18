package fly.leetcode.cn.q26;

/**
 * 26. 删除有序数组中的重复项
 * 跟之前做的一道题好像呀
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        for (int num : nums) {
            if (num!=nums[current]){
                nums[++current] = num;
            }
        }
        return current+1;
    }
}
