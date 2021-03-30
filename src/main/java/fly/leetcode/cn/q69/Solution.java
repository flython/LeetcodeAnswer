package fly.leetcode.cn.q69;

//7*7 = 49
//8*8 = 64

class Solution {
    public int mySqrt(int x) {
        if (x < 2){return x ;}
        long bottom = 2;
        long top = x >> 1 ;
        while (true){
            long t = bottom+top >> 1;
            if (t == bottom){
                return (int) bottom;
            }
            if (t*t == x){
                return (int) t;
            } else if (t*t > x){
                top = t;
            } else {
                bottom = t;
            }
        }
    }
}