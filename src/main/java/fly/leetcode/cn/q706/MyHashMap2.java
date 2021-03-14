package fly.leetcode.cn.q706;

import com.sun.source.tree.Tree;
import org.apache.logging.log4j.core.config.Node;

import java.util.BitSet;

//还没做完
class MyHashMap2 {
    private static class TreeNode {
        TreeNode(int key, int value){
            this.key = key;
            this.value = value;
        }
        int key;
        int value;
        TreeNode left;
        TreeNode right;
    }

    //bucket个数，飘忽不定的执行用时
    public static final int hashBit = 12;
    public static final int firstHashAnd = -1 >>> (32-hashBit);
    public static final int secHashAnd = 0b11111;
    BitSet bitSet = new BitSet();
    TreeNode root = null;
    public void put(int key, int value) {
//        if (bitSet.get(key)){
//
//        } {
//            TreeNode node = new TreeNode(key, value);
//            if (root == null){
//            if (root == null){
//                root = node;
//            } else {
//                TreeNode current = root;
//                while (true){
//                    if (current.left)
//                }
//            }
//        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return 0;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

    }

    private int secIndex(int key){
        return (key >> hashBit)&secHashAnd;
    }
}
