package fly.leetcode.cn.q208;

import org.w3c.dom.Node;

import java.util.LinkedList;

/**
 * 208. 实现 Trie (前缀树)
 */
class Trie {

    Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {

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


