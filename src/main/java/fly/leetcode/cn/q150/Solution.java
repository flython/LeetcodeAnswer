package fly.leetcode.cn.q150;


class Solution {
    public int evalRPN(String[] tokens) {
        int pos = 0;
        int tmp;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    tmp = Integer.parseInt(tokens[pos - 2]) + Integer.parseInt(tokens[--pos]);
                    break;
                case "-":
                    tmp = Integer.parseInt(tokens[pos - 2]) - Integer.parseInt(tokens[--pos]);
                    break;
                case "*":
                    tmp = Integer.parseInt(tokens[pos - 2]) * Integer.parseInt(tokens[--pos]);
                    break;
                case "/":
                    tmp = Integer.parseInt(tokens[pos - 2]) / Integer.parseInt(tokens[--pos]);
                    break;
                default:
                    tokens[pos++] = token;
                    continue;
            }
            tokens[pos - 1] = String.valueOf(tmp);
        }
        return Integer.parseInt(tokens[0]);
    }
}
