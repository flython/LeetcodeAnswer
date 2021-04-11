package fly.leetcode.cn.q154;

/**
 * 4,4,4,4,4,4,0,1,4
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        //需要多考虑相等的情况
        while (l < r-1){
            int mid = (l+r)/2;
            //只要存在反序的情况，说明最小在反序这边
            if (nums[mid]>nums[r]){
                l=mid;
                continue;
            }
            if (nums[l] > nums[mid]){
                r = mid;
                continue;
            }
            //如果不存在反序，则考虑相等的情况
            boolean le = nums[l] == nums[mid];
            boolean re = nums[r] == nums[mid];
            //如果左右中相等，此时可以断定必然有一边是满4的，递归必然需要对满4的那边进行全遍历，所以采用缩减左右边界，直到找到不满足左中右相等
            if (le&&re){
                ++l;
                --r;
                continue;
            } else if (le){
                //当只有左中相等时，此时最小值一点在右边
                r = mid;
                continue;
            }
            //其他情况时，当前范围肯定已有序
            return nums[l];
        }
        return Math.min(nums[l],nums[r]);
    }
}
