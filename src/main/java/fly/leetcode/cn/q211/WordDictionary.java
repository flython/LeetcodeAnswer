package fly.leetcode.cn.q211;

import java.util.Arrays;

class WordDictionary {

//    public WordDictionary() {
//
//    }
//
//    public void addWord(String word) {
//
//    }
//
//    public boolean search(String word) {
//
//    }
//
//
//    public static class DictTreeNode{
//        DictTreeNode[] children = new DictTreeNode[4];
//
//    }
//
//    public static class Dict{
//
//    }

    public static void main(String[] args) {
        int[] ints = "1234567".chars().map(i -> {
            if (i < '1' || i > '7') {
                throw new IllegalArgumentException();
            }
            return i - '0';
        }).toArray();
        System.out.println(Arrays.toString(ints));
    }

}

