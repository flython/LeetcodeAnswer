package fly.leetcode.cn.q1006;

/**
 * https://leetcode-cn.com/problems/clumsy-factorial/
 * 运算顺序出了些问题，明天再看
 */
class Solution {
    //前四个
    private static final int[] lefts= {0,1,2,6};
    public int clumsy(int n) {
        int full = n>>2;
        int left = n&3;
        int minus = lefts[left];
        if (full == 0){
            return minus;
        }
        int minute = n*(n-1)/(n-2)+(n-3);
        for (int i = 1; i < full; i++) {
            n-=4;
            minus+=n*(n-1)/(n-2)-(n-3);
        }
        return minute-minus;
    }
}
