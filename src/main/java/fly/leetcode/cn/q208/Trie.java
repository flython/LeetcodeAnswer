package fly.leetcode.cn.q208;

import org.w3c.dom.Node;

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
        for (char c : word.toCharArray()) {
            
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

    }

    private static class Node{
        Node[] sub = new Node[26];
    }
}


