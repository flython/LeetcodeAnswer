package fly.leetcode.cn.q938;

import fly.leetcode.support.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    int sum = 0;
    int low;
    int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        this.sum = 0;
        bfs(root);
        return sum;
    }

    /**
     * 广度优先搜索BFS
     * @param node
     */
    private void bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.val>=low && poll.val <= high){
                sum+= poll.val;
            }
            if (poll.val > low && poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.val < high && poll.right!=null){
                queue.add(poll.right);
            }
        }
    }


    /**
     * 深度优先搜索DFS
     */
    private void dfs(TreeNode node){
        if (node.val > low && node.left!=null){
            dfs(node.left);
        }
        if (node.val>=low && node.val <= high){
            sum+= node.val;
        }
        if (node.val < high && node.right!=null){
            dfs(node.right);
        }
    }
}