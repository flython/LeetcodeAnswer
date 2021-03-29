package fly.leetcode.cn.q173;

import fly.leetcode.support.TreeNode;

import java.util.LinkedList;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * 把树变成单链
 * 执行用时： 21 ms , 在所有 Java 提交中击败了 99.79% 的用户 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 83.59% 的用户
 */
class BSTIterator {

    TreeNode list = null;
    public BSTIterator(TreeNode root) {
        parseTree(root);
    }

    private void parseTree(TreeNode node){
        if (node.right != null){
            parseTree(node.right);
        }
        node.right = list;
        list = node;
        if (node.left != null){
            parseTree(node.left);
        }
    }

    public int next() {
        int val = list.val;
        list = list.right;
        return val;
    }

    public boolean hasNext() {
        return list != null;
    }
}