package fly.newcoder.q1;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);


        int i = new Solution().run(root);
        System.out.println(i);

    }



}

class Solution {
    public int run(TreeNode root) {
        return wideFirstSearchLeaf2(root);
    }

    public int wideFirstSearchLeaf2(TreeNode root){
        LinkedList<TreeNode> nodeList = new LinkedList();

        if(root == null){
            return 0;
        }else{
            nodeList.add(root);
        }

        int deep = 1;

        while (!nodeList.isEmpty()){
            int toHandleCount = nodeList.size();

            for (int i = 0; i < toHandleCount; ++ i){
                TreeNode node = nodeList.poll();
                if (node.left == null && node.right== null){
                    return deep;
                } else {
                    if(node.left!= null){
                        nodeList.offer(node.left);
                    }
                    if(node.right!= null){
                        nodeList.offer(node.right);
                    }
                }
            }

            ++deep;
        }

        return -1;


    }

    public int wideFirstSearchLeaf(TreeNode root){
        LinkedList<TreeNode> nodeList = new LinkedList();

        if(root == null){
            return 0;
        }else{
            root.val = 1;
            nodeList.add(root);
        }

        while (!nodeList.isEmpty()){

            TreeNode node = nodeList.poll();
            if (node.left == null && node.right== null){
                return node.val;
            } else {
                if(node.left!= null){
                    node.left.val = node.val+1;
                    nodeList.add(node.left);
                }
                if(node.right!= null){
                    node.right.val = node.val+1;
                    nodeList.add(node.right);
                }
            }
        }

        return -1;
    }


}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


