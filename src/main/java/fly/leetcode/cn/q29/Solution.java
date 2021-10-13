package fly.leetcode.cn.q29;

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor > dividend){
            return 0;
        }

        int s = divisor,m = dividend;
        while (s<=m){
            int mid = (s+m)>>1;
        }
        return 0;
    }

    public int mtp(int mt,int p){
        boolean pos = true;
        if(p < 0){
            p = -p;
            pos = false;
        }
        int res = 0;
        while (p != 0){
            if ((p & 1) == 1){
                res += mt;
            }
            mt <<=1;
            p>>=1;
        }
        return pos?res:-res;
    }
}