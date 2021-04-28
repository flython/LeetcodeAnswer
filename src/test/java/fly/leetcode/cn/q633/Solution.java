package fly.leetcode.cn.q633;

import java.util.BitSet;
import java.util.LinkedHashSet;

class Solution {
    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.ceil(Math.sqrt(c));
        for (int i = 0; i <= sqrt; i++) {
            Double d = Double.valueOf(Math.sqrt(c - i * i));
            if (d - d.intValue() == 0){
                return true;
            }
        }
        return false;
    }
}