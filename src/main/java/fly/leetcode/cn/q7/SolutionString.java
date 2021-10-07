package fly.leetcode.cn.q7;

/**
 * 按十进制的整数反转，符号保留
 *
 * 字符串处理法，真直观，可是性能不高
 */
class SolutionString {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        if (x < 0){
            sb.append('-');
            x*=-1;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        try {
            return Integer.valueOf(sb.toString());
        } catch (Exception e){
            return 0;
        }
    }
}