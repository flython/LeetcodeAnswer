package fly.leetcode.interview.q1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 题目中的英文字母是可能重复的，这是一个快速解决方法
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(this::hash));
        return new ArrayList<>(collect.values());
    }

    String hash(String in){
        char[] chars = in.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
