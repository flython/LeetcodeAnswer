package fly.leetcode.cn.q115;

import java.util.Arrays;

class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (s.equals(t) || tLen == 0){
            return 1;
        }
        if (sLen <= tLen){
            return 0;
        }
        //长度+1方便计算(因为需要对index进行-1操作)
        int[] pre = new int[sLen +1];
        //第一列只有一个符号匹配，对所有匹配值加1
        Arrays.fill(pre,1);
        int[] now = new int[sLen +1];
        char[] str = s.toCharArray();
        for (int i = 1; i <= tLen; i++) {
            char cur_pat = t.charAt(i-1);
            //这里感觉还可以减少循环次数
            Arrays.fill(now,0);
            for (int j = i; j <= sLen; j++) {
                if (cur_pat==str[j-1]){
                    now[j] = now[j-1] + pre[j-1];
                } else {
                    now[j] = now[j-1];
                }
            }
            int[] tmp = pre;
            pre = now;
            now = tmp;
        }
        return pre[pre.length-1];
    }
}