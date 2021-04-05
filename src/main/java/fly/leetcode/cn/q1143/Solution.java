package fly.leetcode.cn.q1143;

import java.util.BitSet;

/**
 *
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] markBook = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length(); i++) {
            char c1 = text1.charAt(i);
            for (int j = 0; j < text2.length(); j++) {
                char c2 = text2.charAt(j);
                int matchCount = markBook[i][j];
                if (c1 == c2){
                    matchCount += 1;
                }
                markBook[i+1][j+1] = Math.max(matchCount,Math.max(markBook[i+1][j],markBook[i][j+1]));
            }
        }

        return markBook[text1.length()][text2.length()];
    }
}