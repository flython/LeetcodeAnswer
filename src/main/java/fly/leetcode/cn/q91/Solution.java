package fly.leetcode.cn.q91;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int numDecodings(String s) {
        //处理前导0
        if (s.startsWith("0")){
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        Map<String,Integer> markbook = new HashMap<>();
        markbook.put("",1);
        char[] chars = s.toCharArray();
        //first must not be 0
        sb.append(chars[0]);
        markbook.put(sb.toString(),1);
        for (int i = 1; i < chars.length; i++) {
            //如果是0，那么只能与上一个字符连接(假设输入一定满足的情况下)，所以数量等于 n[i] = n[i-2]
            if (chars[i] == '0'){
                if (sb.charAt(i-1) == '0' || sb.charAt(i-1) > '2'){
                    return 0;
                }
                sb.append(chars[i]);
                markbook.put(sb.toString(),markbook.get(sb.substring(0,i-1)));
            } else {
                //单独作为数字
                int sum = markbook.get(sb.toString());
                //与上一个字符连接
                if ((sb.charAt(i-1) == '1' ) ||( sb.charAt(i-1) == '2' && chars[i] <= '6')){
                    sum += markbook.get(sb.substring(0,i-1));
                }
                sb.append(chars[i]);
                markbook.put(sb.toString(),sum);
            }
            //如果是3-9，那么有两种方案， 1 与上一个字符连接（如果上一个为1或2）（n[i-2]），2 单独作为字符（n[i-1]），n[i] = n[i-1]+n[i-2]
        }

        return markbook.get(s);
    }
}
