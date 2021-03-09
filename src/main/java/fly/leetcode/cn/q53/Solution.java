package fly.leetcode.cn.q53;

class Solution {
    int max = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        if (nums.length < 2){
            return nums[1];
        }
        int last = nums[nums.length-1];
        int tailHilltop = tailHilltop(nums);
        int[] subNums = new int[nums.length - 1];
        System.arraycopy(nums,0,subNums,0,subNums.length);
        return Math.max(last,Math.max(tailHilltop,maxSubArray(subNums)));
    }

    public int tailHilltop(int[] nums){
        Integer top = null;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (top == null){
                top = nums[i];
            }else {
                int sum = top + nums[i];
                if (sum < top){
                    return top;
                } else {
                    top = sum;
                }
            }
        }
        return top;
    }
}
