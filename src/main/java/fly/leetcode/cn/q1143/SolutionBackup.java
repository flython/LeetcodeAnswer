package fly.leetcode.cn.q1143;

import java.util.BitSet;

/**
 * 最长公共子序列只会小于等于较短的那个字符串
 * 返回的是最长公共子序列的长度，感觉可以使用动态规划
 */
class SolutionBackup {
    public int longestCommonSubsequence(String text1, String text2) {
        BitSet checkBook = new BitSet(26);
        //使text1保证成为长字符串
        if (Math.max(text1.length(),text2.length())!=text1.length()){
            var tmp = text1;
            text1=text2;
            text2=tmp;
        }
        int[] markBook = new int[text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            char c = text1.charAt(i);
            for (int j = 0; j < text2.length(); j++) {
                if (text2.charAt(j) == c){
                    checkBook.set(text2.charAt(j)-'a');
                    ++markBook[j];
                    for (int j2 = j+1; j2 < text2.length(); j2++) {
                        markBook[j2] = Math.max(markBook[j2],markBook[j]);
                    }
                }
            }
        }

        return markBook[markBook.length-1];
    }
}