package fly.leetcode.cn.q81;

import java.util.Arrays;

class Solution {

    int[] nums;
    int target;

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        return false;
    }

    private boolean search(int l,int r){
        return Arrays.stream(nums).anyMatch(i->i==target);
    }
}