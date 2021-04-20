package fly.leetcode.cn.q28;

/**
 * Naive string matching
 */
class SolutionPlainStrMatching {
    public int strStr(String haystack, String needle) {
        int pos = 0;
        char[] chars = needle.toCharArray();
        if (needle.length() == 0){
            return 0;
        }
        while (pos <= haystack.length()-needle.length()){
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != haystack.charAt(pos+i)){
                    pos+=1;
                    break;
                } else if (i == chars.length-1){
                    return pos;
                }
            }
        }
        return -1;
    }
}