package fly.leetcode.cn.q230;

import fly.leetcode.support.TreeNode;

/**
 * 二叉搜索树
 */
class Solution {
    int k;
    Integer res = null;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        find(root);
        return res;
    }

    public void find(TreeNode root){
        if (res!=null){
            return;
        }
        if (root.left != null){
            find(root.left);
        }
        if (--k == 0){
            res = root.val;
        }
        if (root.right != null){
            find(root.right);
        }

    }
}
