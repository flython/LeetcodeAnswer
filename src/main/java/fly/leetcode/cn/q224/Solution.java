package fly.leetcode.cn.q224;

import java.util.Stack;

/**
 * 基本计算器
 *  要求：1 <= s.length <= 3 * 105
 *      s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 *      s 表示一个有效的表达式
 *  分析： 1. 使用栈来匹配运算符
 *        2. 匹配到空格或运算符时代表数字转换，空格丢弃，运算符为‘)’进行循环出栈，其他运算符则获取下一个数字进行运算
 *        3. 需要把多个连续的 0-9 转换成 十进制数字
 */

class Solution {

    //TODO： 寻找更优雅的方法，转成逆波兰式应该挺好的
    public int calculate(String s) {
        //构造运算数字
        StringBuilder numBuilder = new StringBuilder();

        // Integer or String
        Stack<Object> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            char c = chars[i];
            if ('0' <= c || c <= '9') {
                numBuilder.append(c);
            } else {
                if (numBuilder.length() != 0) {
                    stack.push(Integer.valueOf(numBuilder.toString()));
                    numBuilder = new StringBuilder();
                }

                switch (c) {
                    case '(':
                        stack.push('c');
                        break;
                    case ')':
                        break;
                    case '+':
                        break;
                    case '-':
                        break;
                    case ' ':
                        break;
                    default:
                        throw new IllegalStateException();
                }
            }
        }
    }
}
