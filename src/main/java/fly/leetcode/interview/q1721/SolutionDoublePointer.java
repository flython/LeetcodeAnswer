package fly.leetcode.interview.q1721;

/**
 * 双指针
 */
class SolutionDoublePointer {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int emptySum = 0;
        int fillSum = 0;
        int lm = 0;
        int rm = 0;
        while (l < r){
            //移动了再添加
            if (height[l] <= height[r]){
                lm = Math.max(lm,height[l]);
                emptySum+=height[l];
                fillSum+=lm;
                ++l;
            } else {
                rm = Math.max(rm,height[r]);
                emptySum+=height[r];
                fillSum+=rm;
                --r;
            }
        }
        return fillSum-emptySum;
    }
}
