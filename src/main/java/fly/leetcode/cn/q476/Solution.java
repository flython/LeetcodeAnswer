package fly.leetcode.cn.q476;

import java.util.Set;

class Solution {
    public int findComplement(int num) {
        int i = 0;
        while (num > 0){
            i++;
            num <<=1;
        }
        num >>= i;
        return ~num;
    }
}