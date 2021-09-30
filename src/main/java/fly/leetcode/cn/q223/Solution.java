package fly.leetcode.cn.q223;


import java.util.Arrays;

/**
 * 太复杂了，几何题，这种题目有一个专业名词：容斥原理
 */
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int Sa = (ax2-ax1)*(ay2-ay1);
        int Sb = (bx2-bx1)*(by2-by1);
        //判断不相交,只要x或y有一段相离就算不相交
        if ((ax2 <= bx1 || bx2 <= ax1) || (ay2 <= by1 || by2 <= ay1)){
            return Sa + Sb;
        }
        //计算相交顶点坐标
        int[] x = {ax1,ax2,bx1,bx2};
        int[] y = {ay1,ay2,by1,by2};
        Arrays.sort(x);
        Arrays.sort(y);
        return Sa+Sb - (x[2]-x[1])*(y[2]-y[1]);
    }
}