package fly.leetcode.cn.q59;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int leftTop = 1;
        int t = n-1;
        int bp = 0;
        do {
            int rightBottom = leftTop + 2*t;
            int ep = bp + t;
            for (int i = 0; i <= t; i++) {
                if (i!= t && i != 0){
                    res[bp+i][ep] = leftTop+t;
                    res[ep-i][bp] = rightBottom+t;
                }
                res[bp][bp+i] = leftTop++;
                res[ep][ep-i] = rightBottom++;
            }
            leftTop = leftTop-1 + 3*t;
            bp++;
            t-=2;
        } while (t > 0);
        if ((n & 1) == 1){
            res[n >> 1][n >> 1] = n*n;
        }
        return res;
    }
}