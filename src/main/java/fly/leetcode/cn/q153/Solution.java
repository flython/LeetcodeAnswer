package fly.leetcode.cn.q153;

/**
 * 寻找旋转右移过的数组的最小值
 *
 * 在有倒置的情况下，无论怎么二分，都有一部分是头大于尾的
 * 如果刚好二分出来两边都是头小于尾，那更小那个头就是最小值
 *
 *
 * 这题不怎么需要考虑二分边界问题
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int mid;
        if (nums[l] <= nums[r]){
            return nums[l];
        }
        while (l < r-1){
            mid = (l+r)/2;
            if (nums[mid] > nums[r]){
                l=mid;
                continue;
            }
            if (nums[l] > nums[mid]){
                r = mid;
                continue;
            }
            return nums[l]<nums[mid]?nums[l]:nums[mid];
        }
        return nums[l]<nums[r]?nums[l]:nums[r];
    }
}