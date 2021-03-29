package fly.leetcode.cn.q297;


import fly.leetcode.support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class Codec {


    /**
     * 想太复杂了，其实根本不用做那么多的控制，抽象思维越好就越不用想那么复杂
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "null";
        }

        Queue<TreeNode> scanQueue = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();
        scanQueue.offer(root);

        //通过广度优先搜索(BFS)，把所有节点值放到list中，然后把list中最后多余的null值删除，最后转换为特定格式的字符串
        while (!scanQueue.isEmpty()){
            TreeNode poll = scanQueue.poll();
            if (poll!=null){
                resultList.add(poll.val);
                scanQueue.offer(poll.left);
                scanQueue.offer(poll.right);
            } else {
                resultList.add(null);
            }

        }

        while (resultList.peekLast() == null){
            resultList.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        resultList.forEach(i-> sb.append(i).append(','));
        return sb.deleteCharAt(sb.length()-1).toString();


    }

    /**
     * 因为上面的序列化算法最后会格式化成满二叉树数组的格式，其中的空节点用null代替，空节点的子节点因为可以通过规则跳过所以会被省略
     *
     * 所以反序列化可以使用Queue来暂存当前需要拼接子节点的根节点，当然记得需要跳过null节点
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")){
            return null;
        }

        Queue<TreeNode> buildQueue = new LinkedList<>();
        String[] split = data.split(",");


        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        buildQueue.offer(root);

        boolean isLeft = true;
        for (int i = 1; i < split.length; i++) {
            String s = split[i];

            TreeNode newNode;
            if (s.equals("null")) {
                newNode = null;
                buildQueue.offer(null);
            } else {
                newNode = new TreeNode(Integer.parseInt(s));
                buildQueue.offer(newNode);
            }

            //跳过所有null节点
            while (buildQueue.peek() == null){
                buildQueue.poll();
            }
            TreeNode parrent = buildQueue.peek();

            if (isLeft){
                parrent.left = newNode;
                isLeft = false;
            } else {
                parrent.right = newNode;
                isLeft = true;
                buildQueue.poll();
            }
        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.right = new TreeNode(3);
        one.right.left = new TreeNode(4);
        one.right.right = new TreeNode(5);

//        System.out.println(new Codec().serialize(null));
        new Codec().deserialize("5,2,3,null,null,2,4,3,1");
    }
}

