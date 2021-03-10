package fly.leetcode.cn.q227;

import java.util.Stack;
import java.util.function.BinaryOperator;

/**
 * 基本计算器
 *  要求：1 <= s.length <= 3 * 105
 *      1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * 12*34/-56*+
 * -
 */

class Solution {
    Stack<Integer> calStack;

    public int calculate(String s) {
        //排除第一个负数的影响
        calStack = new Stack<>();
        Stack<Character> operaStack = new Stack<>();
        StringBuilder nb = new StringBuilder();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch <= '9' && ch >= '0') {
                nb.append(ch);
            } else {
                if (ch == ' ') {
                    continue;
                } else if (ch == '-' && i == 0) {
                    nb.append(ch);
                    continue;
                } else {
                    calStack.push(Integer.valueOf(nb.toString()));
                    nb = new StringBuilder();
                }

                switch (ch) {
                    case '+':
                    case '-':
                        while (!operaStack.empty()) {
                            doCal(operaStack.pop());
                        }
                        operaStack.push(ch);
                        break;
                    case '*':
                    case '/':
                        while (!operaStack.empty()) {
                            char peek = operaStack.peek();
                            if (peek == '*' || peek == '/') {
                                doCal(operaStack.pop());
                            } else {
                                break;
                            }
                        }
                        operaStack.push(ch);
                        break;
                }
            }
        }

        if (nb.length() > 0){
            calStack.add(Integer.valueOf(nb.toString()));
        }
        while (!operaStack.empty()){
            doCal(operaStack.pop());
        }
        return calStack.pop();
    }

    void doCal(char op){
        Integer r =calStack.pop();
        Integer l =calStack.pop();
        switch (op){
            case '+':
                calStack.push(l+r);
                break;
            case '*':
                calStack.push(l*r);
                break;
            case '-':
                calStack.push(l-r);
                break;
            case '/':
                calStack.push(l/r);
                break;

        }
    }

}
