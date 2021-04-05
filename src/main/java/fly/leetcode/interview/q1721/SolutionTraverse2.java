package fly.leetcode.interview.q1721;

/**
 * 直接遍历做法
 * 缺点：需要遍历两次
 */
class SolutionTraverse2 {
    public int trap(int[] height) {
        if (height.length <3){return 0;}
        int heigest = 0;
        int emptySum = 0;
        //先找出最大值，并顺便计算出所有石头的数量和
        for (int i = 0; i < height.length; i++) {
            emptySum+=height[i];
            heigest = Math.max(heigest,height[i]);
        }
        int fillSum = 0;
        int currentMax = 0;
        int lh,rh;
        //从两边开始向中间便历，每遇到一个，就加上相当于遍历中最高这么多的水分
        for (lh = 0; height[lh] != heigest; lh++) {
            currentMax = Math.max(currentMax,height[lh]);
            fillSum+=currentMax;
        }
        currentMax = 0;
        for (rh = height.length - 1; height[rh] != heigest; rh--) {
            currentMax = Math.max(currentMax,height[rh]);
            fillSum+=currentMax;
        }

        //有可能数组中有两个最大值，最大值中间全都按最大值填水分
        fillSum += (rh-lh+1)*heigest;

        //使用全满的水分数量减去石头的数量，即为填充的水分
        return fillSum-emptySum;

    }
}
