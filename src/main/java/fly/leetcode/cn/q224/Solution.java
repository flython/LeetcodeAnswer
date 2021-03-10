package fly.leetcode.cn.q224;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import static org.apache.logging.log4j.ThreadContext.peek;
import static org.apache.logging.log4j.ThreadContext.pop;

/**
 * 基本计算器
 *  要求：1 <= s.length <= 3 * 105
 *      s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 *      s 表示一个有效的表达式
 *  分析： 1. 使用栈来匹配运算符
 *        2. 匹配到空格或运算符时代表数字转换，空格丢弃，运算符为‘)’进行循环出栈，其他运算符则获取下一个数字进行运算
 *        3. 需要把多个连续的 0-9 转换成 十进制数字
 *        4. 中缀运算式转后缀运算式时，优先级 (/,*)>(-,+)
 *        5. 使用逆波兰式求解法
 */

class Solution {

    public int calculate(String s) {
        //排除第一个负数的影响
        s = s.strip();
        if (s.startsWith("-")){
            s = "0"+s;
        }

        // Integer or String
        Stack<Integer> calStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        //构造运算数字
        StringBuilder numBuilder = new StringBuilder();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if ('0' <= c && c <= '9'){
                numBuilder.append(c);
            }else {
                if (c == ' '){
                    continue;
                }

                if (numBuilder.length() > 0){
                    calStack.push(Integer.valueOf(numBuilder.toString()));
                    numBuilder = new StringBuilder();
                } else if (c == '-' && !operatorStack.isEmpty() && operatorStack.peek().equals('(')){
                    //处理负数
                    // 如果在扫描到负号时，builder为空，则说明刚刚才扫描到一个字符，则该负号为数字所有
                    numBuilder.append(c);
                    continue;
                }

                switch (c){
                    case '(':
                        operatorStack.push(c);
                        break;
                    case '+':
                    case '-':
                        if (!operatorStack.isEmpty() && !operatorStack.peek().equals('(')) {
                            doCal(operatorStack.pop(),calStack);
                        }
                        operatorStack.push(c);
                        break;
                    case ')':
                        for (char op = operatorStack.pop(); op != '(' ; op = operatorStack.pop()) {
                            doCal(op,calStack);
                        }
                        break;
                    default:
                }

            }
        }

        if (numBuilder.length() > 0){
            calStack.push(Integer.valueOf(numBuilder.toString()));
        }
        operatorStack.forEach(op->doCal(op,calStack));
        return (Integer) calStack.pop();
    }

    void doCal(char op,Stack<Integer> calStack){
        Integer r =calStack.pop();
        Integer l =calStack.pop();
        switch (op){
            case '+':
                calStack.push(r+l);
                break;
            case '-':
                calStack.push(l-r);
                break;
            default:
        }
    }

}
