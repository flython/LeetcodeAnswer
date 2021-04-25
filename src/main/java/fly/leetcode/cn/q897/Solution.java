package fly.leetcode.cn.q897;


import fly.leetcode.support.TreeNode;

class Solution {

    TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        //初始化
        head = null;
        buildList(root);
        return head;
    }

    private void buildList(TreeNode node){
        if (node.right != null){
            buildList(node.right);
        }
        node.right = head;
        head = node;
        if (node.left != null){
            buildList(node.left);
        }
        node.left = null;
    }
}