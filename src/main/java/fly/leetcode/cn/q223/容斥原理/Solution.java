package fly.leetcode.cn.q223.容斥原理;


/**
 * 太复杂了，几何题，这种题目有一个专业名词：容斥原理
 * 这里补充一个线段关系的知识：
 * 现在有两条平行线段计算相交长度，忽略y坐标
 * x1---x2,x3---x4
 * 长度等于中间的两个坐标差值，0就是相接，>0就是有相交，<0就是相离
 * 而因为我们知道x4 > x3, x2 > x1,所以只需要判断1，3  2，4之间的大小关系就可以找到中间两点了
 */
public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int Sa = (ax2-ax1)*(ay2-ay1);
        int Sb = (bx2-bx1)*(by2-by1);
        int x = Math.max(0,Math.min(ax2,bx2)-Math.max(ax1,bx1));
        int y = Math.max(0,Math.min(ay2,by2)-Math.max(ay1,by1));

        return Sa+Sb - x*y;
    }
}