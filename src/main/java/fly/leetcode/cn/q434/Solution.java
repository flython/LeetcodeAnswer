package fly.leetcode.cn.q434;

/**
 * 简单遍历统计，寄了
 */
class Solution {
    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        char count = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((i == 0 || chars[i-1] == ' ') && chars[i] != ' '){
                count++;
            }
        }
        return count;
    }
}