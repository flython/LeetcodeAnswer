package fly.leetcode.cn.q1006;

/**
 * https://leetcode-cn.com/problems/clumsy-factorial/
 * 运算顺序出了些问题，明天再看
 */
class Solution {
    public int clumsy(int n) {
        int full = n>>2;
        int least = n&3;
        int minute = n*(n-1)/(n-2)+(n-3);
        int minus = 0;
        for (int i = 1; i < full; i++) {
            int base = n-(i << 2);
            minus+=base*(base-1)/(base-2)+(base-3);
        }
        //3*2/1
        switch (least){
            case 3:
                minus+=6;
            case 2:
                minus+=2;
            case 1:
                minus+=1;
        }

        return minute-minus;
    }
}
