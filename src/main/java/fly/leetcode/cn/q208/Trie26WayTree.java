package fly.leetcode.cn.q208;

import java.util.LinkedList;

/**
 * 208. 实现 Trie (前缀树)
 * 执行用时： 54 ms , 在所有 Java 提交中击败了 22.36% 的用户
 * 内存消耗： 55.9 MB , 在所有 Java 提交中击败了 5.02% 的用户
 *
 */
class Trie26WayTree {

    Node root = new Node();

    /** Initialize your data structure here. */
    public Trie26WayTree() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            Node next = cur.sub[c-'a'];
            if (next == null){
                next = new Node();
                cur.sub[c-'a'] = next;
            }
            cur = next;
        }
        if (!cur.values.contains(word)){
            cur.values.add(word);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            Node next = cur.sub[c-'a'];
            if (next == null){
                return false;
            }
            cur = next;
        }
        return cur.values.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private Node searchNode(String word){
        Node cur = root;
        for (char c : word.toCharArray()) {
            Node next = cur.sub[c-'a'];
            if (next == null){
                return null;
            }
            cur = next;
        }
        return cur;
    }

    private static class Node{
        Node[] sub = new Node[26];
        LinkedList<String> values = new LinkedList<>();
    }
}


