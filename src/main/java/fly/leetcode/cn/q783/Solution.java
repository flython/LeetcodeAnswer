package fly.leetcode.cn.q783;

import fly.leetcode.support.TreeNode;

/**
 * 1. 二叉搜索树变链（中序遍历也行）
 * 2. 计算每一个间隔
 */
class Solution {
    int min;
    TreeNode list;
    public int minDiffInBST(TreeNode root) {
        list = null;
        min = Integer.MAX_VALUE;
        rightDfs(root);
        return min;
    }

    private void rightDfs(TreeNode node){
        if (node.right != null){
            rightDfs(node.right);
        }
        if (list!=null){
            min = Math.min(min, list.val - node.val);
        }
        list = node;
        if (node.left != null){
            rightDfs(node.left);
        }
    }
}