package fly.leetcode.cn.q224;

import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * 基本计算器
 *  #TODO 还没做完，要找更方便的方法来做
 */

class Solution2 extends Solution{

    BinaryOperator<Integer> add = (a,b)->a+b;
    BinaryOperator<Integer> minus = (a,b)->a-b;

    @Override
    public int calculate(String s) {
        StringBuilder nb = new StringBuilder();
        int singleBracketCount = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (c == '-'){
                if (i == 0){
                    nb.append(c);
                }
                if (singleBracketCount == 0){
                    return minus.apply(calculate(nb.toString()),calculate(s.substring(i+1)));
                }
            } else if (c == '+'){
                if (singleBracketCount == 0){
                    return add.apply(calculate(nb.toString()),calculate(s.substring(i+1)));
                }
            } else if (c<='9' && c >= '0'){
                nb.append(c);
            } else if (c == '('){
                nb.append(c);
                singleBracketCount++;
            } else if (c == ')'){
                nb.append(c);
                singleBracketCount--;
            }

        }
        return Integer.valueOf(nb.toString());
    }



}
