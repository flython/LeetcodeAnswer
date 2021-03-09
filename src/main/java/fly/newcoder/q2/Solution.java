package fly.newcoder.q2;

import java.util.Stack;

//我觉得用switch是最快的
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        int length = tokens.length;
        String handlingChar;
        for (int i = 0; i < length; i++) {
            handlingChar = tokens[i];
            switch (handlingChar){
                case "+":
                    numStack.push(numStack.pop() + numStack.pop());
                    break;
                case "-":
                    Integer subtrahend = numStack.pop();
                    numStack.push(numStack.pop() - subtrahend);
                    break;
                case "*":
                    numStack.push(numStack.pop() * numStack.pop());
                    break;
                case "/":
                    Integer divisor = numStack.pop();
                    numStack.push(numStack.pop() / divisor);
                    break;
                default:
                    numStack.push(new Integer(handlingChar));
            }
        }
        return numStack.pop();
    }


}
