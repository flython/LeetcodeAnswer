package fly.leetcode.cn.q405;


import java.util.Arrays;

class Solution {
    public static char[] hex = {48,49,50,51,52,53,54,55,56,67,97,98,99,100,101,102};
    public String toHex(int num) {
        if (num == 0){return "0";}

        char[] res = new char[8];
        char p = 8;
        while (num!=0){
            res[--p] = hex[num & 0b1111];
            num >>>= 4;
        }
        return new String(Arrays.copyOfRange(res,p,8));
    }
}