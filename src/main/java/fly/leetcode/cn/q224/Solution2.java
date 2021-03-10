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
 *        4. 中缀运算式转后缀运算式时，优先级 (/,*)>(-,+)
 *        5. 使用逆波兰式求解法
 */

class Solution2 extends Solution{

    @Override
    public int calculate(String s) {
        s = s.strip();
        Integer val1 = null, val2 = null;
        char oper;

        switch (s.charAt(0)){
            case '-': break;
            case '(': break;
            default:

                break;
        }

        return 0;
    }



}
