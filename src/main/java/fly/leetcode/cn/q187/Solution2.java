package fly.leetcode.cn.q187;

import java.util.Collections;
import java.util.List;

//class Solution2 {
//    char[] chars;
//    public List<String> findRepeatedDnaSequences(String s) {
//        if (s.length() <= 10){
//            return Collections.emptyList();
//        }
//        chars = s.toCharArray();
//
//    }
//
//    private int hash(int pos){
//        int h = 0;
//        for (int i = pos; i < 10; i++) {
//            h = 31 * h + chars[i];
//        }
//        return h;
//    }
//
//    private boolean equal(int p1,int p2){
//        if(p2 + 10 >= chars.length){
//            return false;
//        }
//        for (int i = 0; i < 10; i++) {
//            if (chars[p1+i] != chars[p2+i]){
//                return false;
//            }
//        }
//        return true;
//    }
//}