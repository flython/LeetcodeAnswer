package fly.leetcode.cn.q331;


import java.util.*;

/**
 * 331. 验证二叉树的前序序列化
 * 9,3,4,#,#,1,#,#,2,#,6,#,#
 * 9,3,4,#,#,1,#,#,2,#,6,#,#
 * 分析 1 每个可以去掉的叶子结点，根据前序遍历规则，后面必然带有两个#
 *     2 所以可以尝试把所有 “1 # #” 这样形式的当作是一个叶子节点，这样的一个叶子节点可以替换成一个 “#”
 *     3 最终整个序列都会被替换为只剩下一个 #
 *
 * 思路 工作分成两步，1 把数据原始处理成适合递归或循环， 2 使用递归或循环进行检查
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")){
            return true;
        }
        if (preorder.length() < 5){
            return false;
        }
        Stack<String> stack = new Stack<>();

        String[] split = preorder.split(",");
        for (String s : split) {
            stack.push(s);
        }

        return check(stack);

    }


    boolean check(Stack<String> stack){
        //第一次没有考虑周全，没有考虑到每次都不能消除的的情况，造成虚拟机栈溢出,思考的时候得按照分支来，考虑没有消除怎么办
        int firstLen = stack.size();
        if (stack.size() < 3){
            if (stack.size() == 1 && stack.peek() == "#"){
                return true;
            } else {
                return false;
            }
        }

        LinkedList tempPop = new LinkedList();
        int len;
        while ((len = stack.size()) >= 3){
            boolean tailIsLeaf = stack.get(len-1).equals("#") &&
                    stack.get(len-2).equals("#") &&
                    !stack.get(len-3).equals("#");
            if (tailIsLeaf){
                for (int i = 0; i < 3; i++) {
                    stack.pop();
                }
                stack.push("#");
            } else {
                tempPop.addFirst(stack.pop());
            }
        }
        stack.addAll(tempPop);
        if (stack.size() < firstLen){
            return check(stack);
        } else {
            return false;
        }
    }

}