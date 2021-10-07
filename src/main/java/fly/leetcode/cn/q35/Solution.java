package fly.leetcode.cn.q35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            if(num >= target){
                return i;
            }
        }
        return nums.length;
    }
}