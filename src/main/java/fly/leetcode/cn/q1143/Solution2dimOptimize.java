package fly.leetcode.cn.q1143;

import java.util.BitSet;

/**
 * 最长公共子序列只会小于等于较短的那个字符串
 * 返回的是最长公共子序列的长度，感觉可以使用动态规划
 */
class Solution2dimOptimize {
    public int longestCommonSubsequence(String text1, String text2) {
        //使text1保证成为长字符串
        if (Math.max(text1.length(),text2.length())!=text1.length()){
            var tmp = text1;
            text1=text2;
            text2=tmp;
        }
        int[] markBook = new int[text2.length()+1];
        int leftUp = 0;
        int pairCount = 0;
        for (int i = 0; i < text1.length(); i++) {
            char c = text1.charAt(i);
            leftUp = 0;
            for (int j = 0; j < text2.length(); j++) {
                pairCount = leftUp;
                if (text2.charAt(j) == c){
                    pairCount+=1;
                }
                //因为现在修改的这一格，在下一轮循环中需要用到，提前记下来
                leftUp=markBook[j+1];
                markBook[j+1] = Math.max(pairCount,Math.max(markBook[j+1],markBook[j]));
            }
        }
        return markBook[text2.length()];
    }
}