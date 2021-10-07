package fly.leetcode.cn.q166;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

/**
 * 未做完
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){return "0";}
        boolean negative = (numerator ^ denominator) < 0;

        //绝对值运算
        long numeratorL = Math.abs((long)numerator);
        long denominatorL = Math.abs((long)denominator);

        long intPart = numeratorL / denominatorL;
        //余数进位
        numeratorL = (numeratorL % denominatorL)*10;
        StringBuilder sb = new StringBuilder();
        HashMap<Long,Integer> loopChecker = new HashMap<>();
        //小数位指示
        int index = 0;
        while (numeratorL != 0){
            //找到循环小数，退出循环
            if (loopChecker.containsKey(numeratorL)){break;}
            //当前小数位的商
            long de = numeratorL / denominatorL;
            //记录下结果对应的位数
            loopChecker.put(numeratorL,index++);
            //下一位进位
            numeratorL = (numeratorL % denominatorL)*10;
            sb.append(de);
        }
        if (numeratorL != 0){
            index = loopChecker.get(numeratorL);
            sb.insert(index,'(');
            sb.insert(sb.length(),')');
        }
        if (sb.length() > 0){
            sb.insert(0,'.');
        }
        sb.insert(0,intPart);
        if (negative){
            sb.insert(0,'-');
        }
        return sb.toString();
    }
}
