package fly.leetcode.cn.q331;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 331. 验证二叉树的前序序列化
 * 9,3,4,#,#,1,#,#,2,#,6,#,#

 * 分析 1 每个可以去掉的叶子结点，根据前序遍历规则，后面必然带有两个#
 *     2 所以可以尝试把所有 “1 # #” 这样形式的当作是一个叶子节点，这样的一个叶子节点可以替换成一个 “#”
 *     3 最终整个序列都会被替换为只剩下一个 #
 *
 *
 */

class Solution2 {
    //java 这里借助了split，需要遍历两次，也可以修改直接只需要遍历一次就行，但没必要，写完以后代码不好看
    public boolean isValidSerialization(String preorder){
        String[] split = preorder.split(",");
        int nullCount=0;
        //后序遍历数组
        for (int i = split.length - 1; i >= 0; i--) {
            String s = split[i];
            if (s.equals("#")) {
                nullCount++;
            } else if (nullCount >= 2) {
                // 如果遇到值节点，则把两个空节点跟一个值节点替换成一个值节点，表现在遍历里就是nullCount-1
                // 但必须在前面至少拥有两个空节点
                nullCount--;
            } else {
                return false;
            }
        }
        // 最后符合要求的字符串肯定只剩下一个空节点
        return nullCount==1;
    }

    public boolean isValidSerialization2(String preorder) {
        preorder = ','+preorder;
        int nullCount=0;
        StringBuilder sb = new StringBuilder();
        for (int i = preorder.length() - 1; i >= 0; i--) {
            char c = preorder.charAt(i);
            if (c==','){
                if (sb.toString().equals("#")) {
                    nullCount++;
                } else if (nullCount >= 2) {
                    nullCount--;
                } else {
                    return false;
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        return nullCount==1;
    }
}