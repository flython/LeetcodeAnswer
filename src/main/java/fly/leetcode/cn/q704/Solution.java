package fly.leetcode.cn.q704;

/**
 * <a href="https://programmercarl.com/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.html#%E6%80%9D%E8%B7%AF">代码随想录-二分查找</a>
 */
class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        //1. 二分定义数组开闭
        //2. 根据开闭定义下次下标
        while (l <= r){
            int mid = (l+r)>>1;
            if (nums[mid]==target){return mid;}
            if (nums[mid] < target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }
}
