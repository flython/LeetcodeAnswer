package fly.leetcode.support;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (left != null){
            stringBuilder.append(String.format(" [%s]<-", left.toString()));
        }
        stringBuilder.append(val);
        if (right != null){
            stringBuilder.append(String.format("->[%s] ", right.toString()));
        }
        return stringBuilder.toString();
    }
}
