package fly.leetcode.cn.q28;

/**
 * 增强
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int pos = 0;
        int step = 1;
        char[] chars = needle.toCharArray();
        if (needle.length() == 0){
            return 0;
        }
        //预分析匹配的字符串
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[0]){
                step = i+1;
                break;
            }
        }
        while (pos <= haystack.length()-needle.length()){
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != haystack.charAt(pos+i)){
                    //这里还能优化
                    pos+=Math.min(i+1,step);
                    break;
                } else if (i == chars.length-1){
                    return pos;
                }
            }
        }
        return -1;
    }
}