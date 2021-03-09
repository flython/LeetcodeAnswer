package fly.leetcode.cn.q1047;


import javax.swing.event.ChangeEvent;
import java.util.stream.IntStream;

/**
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder reduce = S.chars().collect(StringBuilder::new, (sb, c) -> {
            char ch = (char) c;
            int lastIndex = sb.length() - 1;
            if (lastIndex < 0 || ch != sb.charAt(lastIndex)) {
                sb.append(ch);
            } else {
                sb.deleteCharAt(lastIndex);
            }
        },(a,b)->{});
        return reduce.toString();
    }
}