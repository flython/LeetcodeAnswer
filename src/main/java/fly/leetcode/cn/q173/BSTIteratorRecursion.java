package fly.leetcode.cn.q173;

import fly.leetcode.support.TreeNode;

import java.util.Iterator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * 一个递归的解法，速度不怎样
 * 执行用时： 25 ms , 在所有 Java 提交中击败了 28.22% 的用户 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 97.49% 的用户
 */
class BSTIteratorRecursion {

    int[] vales;
    int pos = 0;

    public BSTIteratorRecursion(TreeNode root) {
        IntStream.Builder builder = IntStream.builder();
        parseTree(root,builder);
        vales = builder.build().toArray();
    }

    public int next() {
        return vales[pos++];
    }

    public boolean hasNext() {
        return pos < vales.length;
    }

    private void parseTree(TreeNode root, IntConsumer midRoots){
        if (root.left != null){
            parseTree(root.left,midRoots);
        }
        midRoots.accept(root.val);
        if (root.right!= null){
            parseTree(root.right,midRoots);
        }
    }
}