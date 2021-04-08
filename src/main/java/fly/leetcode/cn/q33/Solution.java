package fly.leetcode.cn.q33;

/**
 * 33. 搜索旋转排序数组
 *
 * 做范围搜索，要特别注意边界元素的问题
 * [4,5,6,7,0,1,2]
 * 0
 *
 * 主要的问题是，每次二分以后，都存在两种情况，一边是有序的，一边是奇序的
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        //二分出口：lr明确交错
        while (l <= r){
            int mid = (l+r)/2;
            if (nums[l] <= nums[r]){
                //正序情况
            }
        }
    }

    private int search(int l, int r){

    }
}