package fly.leetcode.cn.q783;

import fly.leetcode.support.TreeNode;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 1. 二叉搜索树变链（中序遍历也行）
 * 2. 计算每一个间隔
 */
class Solution {


    public int minDiffInBST(TreeNode root) {
        list = null;
        parseTree(root);
        int min = Integer.MAX_VALUE;
        while (list.right != null){
            min = Math.min(min,list.right.val - list.val);
            list = list.right;
        }
        return min;
    }

    TreeNode list;

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



}