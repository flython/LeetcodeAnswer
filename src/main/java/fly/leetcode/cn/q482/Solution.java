package fly.leetcode.cn.q482;

import java.util.stream.IntStream;

/**
 * 问题用例
 * "--a-a-a-a--"
 * 2
 * "----a------a-a-a--"
 * 2
 */
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '-') {
                continue;
            }
            sb.append((c >= 'a' && c <= 'z')?c-32:c);
        }
        int len = sb.length()-k;
        while (len > 0){
            sb.insert(len,"-");
            len-=k;
        }
        return sb.toString();
    }
}