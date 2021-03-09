package fly.leetcode.cn.q1208;

import fly.leetcode.cn.support.TreeNode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 1028. 从先序遍历还原二叉树
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 */
class Solution {

    Pattern pattern = Pattern.compile("-*[0-9]+");
    public TreeNode recoverFromPreorder(String str) {
        return stack(str);
    }


    /**
     * TODO: 有没有更快的解题方法呢？
     * @param str
     * @return
     */
    public TreeNode nextSolve(String str){
        return null;
    }


    /**
     * 使用栈，不需要继承了，但是还是好慢呀
     */
    public TreeNode stack(String str){
        Matcher matcher = pattern.matcher(str);
        TreeNode root;
        //firstNode;
        matcher.find();
        root = new TreeNode(Integer.parseInt(matcher.group()));

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        while (matcher.find()){
            String nodeStr = matcher.group();
            int newDeep = nodeStr.lastIndexOf('-')+1;
            int currentDeep = stack.size()-1;
            TreeNode newNode = new TreeNode(Integer.parseInt(nodeStr.substring(newDeep)));
            if (currentDeep == newDeep){
                stack.pop();
                stack.peek().right = newNode;
            } else if (newDeep > currentDeep){
                stack.peek().left = newNode;
            } else {
                //newDeep < currentDeep
                for (int i = 0; i < currentDeep - newDeep + 1; i++) {
                    stack.pop();
                }
                stack.peek().right = newNode;
            }
            stack.push(newNode);

        }

        return root;
    }

    //简单迭代，使用扩展类
    public TreeNode supportClass(String str){
        Matcher matcher = pattern.matcher(str);
        ParrentTreeNode root,currentNode;
        //firstNode;
        matcher.find();
        root = new ParrentTreeNode(Integer.parseInt(matcher.group()));
        currentNode = root;

        int currentDeep = 0;
        while (matcher.find()){
            String nodeStr = matcher.group();
            int deepCount = nodeStr.lastIndexOf('-')+1;
            ParrentTreeNode newNode = new ParrentTreeNode(Integer.parseInt(nodeStr.substring(deepCount)));
            if (deepCount == currentDeep){
                newNode.parrent = currentNode.parrent;
                currentNode.parrent.right = newNode;
            } else if (deepCount > currentDeep){
                newNode.parrent = currentNode;
                currentNode.left = newNode;
            } else {
                //deepCount < currentDeep
                for (int i = 0; i < currentDeep - deepCount; i++) {
                    currentNode = currentNode.parrent;
                }
                newNode.parrent = currentNode.parrent;
                currentNode.parrent.right = newNode;
            }
            currentDeep = deepCount;
            currentNode = newNode;
        }
        return root;
    }

    public static void main(String[] args) {
        // 1-401--349---90-88
        TreeNode treeNode = new Solution().recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println(treeNode);
    }

    public class ParrentTreeNode extends TreeNode{

        ParrentTreeNode parrent;

        public ParrentTreeNode(int x) {
            super(x);
        }
    }
}
