package fly.leetcode.cn.q282;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 尝试使用回溯法思考
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 */
class Solution {
    int target;
    List<String> resp = new LinkedList();
    Deque<String> context = new LinkedList<>();
    String num;

    public List<String> addOperators(String num, int target) {
        this.target = target;
        this.num = num;
        for (int i = 1; i <= num.length(); i++) {
            String startNum = num.substring(0,i);
            try{
                Integer startVal = Integer.valueOf(startNum);
                context.add(startNum);
                btc(startVal, i);
                context.removeLast();
                if (startVal == 0){break;}
            } catch (NumberFormatException ignore){}

        }
        return resp;
    }

    public void btc(int value, int startIndex){
        // 终止条件
        if (startIndex == num.length()){
            String str = context.stream().collect(Collectors.joining());
            if (new Cal().calculate(str) == target) {
                resp.add(str);
            }
            return;
        }

        for (int i = startIndex+1; i <= num.length(); i++) {
            String s = num.substring(startIndex,i);
            try{
                Integer levelVal = Integer.valueOf(s);
                context.add("+");
                context.add(s);
                btc(value+levelVal,i);
                context.removeLast();
                context.removeLast();

                context.add("-");
                context.add(s);
                btc(value- levelVal,i);
                context.removeLast();
                context.removeLast();

                context.add("*");
                context.add(s);
                btc(value*levelVal,i);
                context.removeLast();
                context.removeLast();

                if (levelVal == 0){break;}
            } catch (NumberFormatException ignore){
            }

        }
    }


    public static class Cal {
        Stack<Long> calStack;

        public long calculate(String s) {
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
                        calStack.push(Long.valueOf(nb.toString()));
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
                calStack.add(Long.valueOf(nb.toString()));
            }
            while (!operaStack.empty()){
                doCal(operaStack.pop());
            }
            return calStack.pop();
        }

        void doCal(char op){
            Long r =calStack.pop();
            Long l =calStack.pop();
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
            }
        }

    }


}
