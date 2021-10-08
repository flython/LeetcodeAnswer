package fly.leetcode.cn.q187;

import java.util.*;

class Solution {
    char[] chars;
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10){
            return Collections.emptyList();
        }
        chars = s.toCharArray();

        Map<Integer,Integer> hashMap = new HashMap<>();
        List<String> res = new LinkedList<>();
        Integer curHash = 0;
        for (int i = 0; i <= chars.length-10; i++) {
            curHash = hash(curHash,i);
            Integer count = hashMap.get(curHash);
            if (count != null){
                if (count == 1){
                    res.add(s.substring(i,i+10));
                }
                hashMap.put(curHash,count+1);
            } else {
                hashMap.put(curHash,1);
            }
        }
        return res;
    }

    private int hash(int preHash, int pos){
        //通过上一次的hash来显著减少hash计算时间
        int h = (preHash >> 12) & 0b111111111111111111;
        int i = preHash == 0? 0:9;
        for (; i < 10; i++) {
            h <<= 2;
            switch (chars[i+pos]){
                case 'A':
                    h+= 0;
                    break;
                case 'C':
                    h+= 1;
                    break;
                case 'G':
                    h+= 2;
                    break;
                case 'T':
                    h+= 3;
                    break;
            }
        }
        return h << 12;
    }

}