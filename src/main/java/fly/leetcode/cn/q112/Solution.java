package fly.leetcode.cn.q112;

import fly.leetcode.cn.q297.Codec;
import fly.leetcode.support.TreeNode;


/**
 * 输入:
 * [1,-2,-3,1,3,-2,null,-1]
 * -1
 * 输出
 * false
 * 预期结果
 * true
 *
 * TODO：找到问题 ： https://leetcode-cn.com/problems/path-sum/submissions/
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        try{
            return checkSubTree(root,sum,0);
        }catch (Exception e){
            return false;
        }
    }


    boolean checkSubTree(TreeNode currentNode, int target, int currentSum){
        if (currentNode == null){
            return false;
        }
        int newSumVal = currentNode.val + currentSum;
        if (newSumVal == target){
            if (currentNode.left == null && currentNode.right == null){
                return true;
            } else {
                return false;
            }
        } else {
            return checkSubTree(currentNode.left,target,newSumVal) || checkSubTree(currentNode.right,target,newSumVal);
        }

    }

    public static void main(String[] args) {
       TreeNode root = new Codec().deserialize("1,-2,-3,1,3,-2,null,-1");
        boolean b = new Solution().hasPathSum(root, -1);
        System.out.println(b);
    }
}
