package fly.leetcode.cn.q416;

class Solution {
    public boolean canPartition(int[] nums) {
        int mid = 0;
        for (int num : nums) {
            mid+=num;
        }
        if ((mid & 1) == 1){return false;}
        mid = mid >>1;
        int[] dp = new int[mid + 1];
        //初始化
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],nums[i] + dp[j-nums[i]]);
            }
        }
        return dp[mid] == mid;
    }
}