package fly.leetcode.cn.q783;

import fly.leetcode.support.TreeNode;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 通用解法，忽略了这是二叉搜索树
 */
class SolutionIgnoreBST {
    int min;
    LinkedList<TreeNode> stack = new LinkedList<>();
    ConcurrentSkipListSet<Integer> sl = new ConcurrentSkipListSet<>();

    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        sl.clear();
        stack.clear();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.left!= null){
                stack.push(pop.left);
            }
            if (pop.right!=null){
                stack.push(pop.right);
            }

            if (sl.contains(pop.val)){
                return 0;
            }
            Integer smaller = sl.floor(pop.val - 1);
            if (smaller!=null){
                min = Math.min(min, pop.val-smaller);
            }
            Integer higher = sl.higher(pop.val);
            if (higher!=null){
                min = Math.min(min,higher- pop.val);
            }
            sl.add(pop.val);
        }

        return min;
    }

}