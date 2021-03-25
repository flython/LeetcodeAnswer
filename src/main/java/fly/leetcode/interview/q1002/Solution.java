package fly.leetcode.interview.q1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(this::hash));
        return new ArrayList<>(collect.values());
    }

    public int hash(String str){
        int and =  -1;
        int or = -1 << 8;
        int xor =  -1 << 8;
        for (char c : str.toCharArray()) {
            //使用前四位混淆后四位

            and &= c;
            or |= c;
            xor ^= c;
        }

        return  xor << 16 ^ or << 8 ^ and;
    }
}
