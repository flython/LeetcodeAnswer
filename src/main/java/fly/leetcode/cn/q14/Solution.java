package fly.leetcode.cn.q14;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        } else if (strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int max = Math.min(sb.length(),str.length());
            int j;
            for ( j = 0; j < max; ++j){
                if (sb.charAt(j) != str.charAt(j)){
                    break;
                }
            }
            sb.delete(j,sb.length());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = new Solution().longestCommonPrefix(strs);
        System.out.println(":" + s);
    }
}
