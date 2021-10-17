package fly.leetcode.cn.q38;

class Solution {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }

        String pre =  countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char[] chars = pre.toCharArray();
        char cur = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur){
                count++;
            } else {
                sb.append(count).append(cur);
                count = 1;
                cur = chars[i];
            }
        }
        sb.append(count).append(cur);
        return sb.toString();
    }
}