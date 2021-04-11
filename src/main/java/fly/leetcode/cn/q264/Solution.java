package fly.leetcode.cn.q264;

import java.util.BitSet;

/**
 *  动态规划 三指针动态生成新丑数
 */
class Solution {

    static final int ugly[] = new int[1690];
    static int t2 = 0;
    static int t3 = 0;
    static int t5 = 0;
    static int next = 1;
    static{
        ugly[0] = 1;
    }

    public int nthUglyNumber(int n) {
        while (ugly[n-1]==0){
            int next2,next3,next5;
            next2 = ugly[t2]*2;
            next3 = ugly[t3]*3;
            next5 = ugly[t5]*5;
            ugly[next] = Math.min(next2,Math.min(next3,next5));
            if (ugly[next] == next2){
                ++t2;
            }
            if (ugly[next] == next3){
                ++t3;
            }
            if (ugly[next] == next5){
                ++t5;
            }
            ++next;
        }
        return ugly[n-1];
    }
}