package fly.leetcode.interview.q1002;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目中的英文字母是可能重复的，这是一个快速解决方法
 */
class SolutionHash {
    //使用质数映射搭配乘法，可以保证不重复
    public static int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> collect = new HashMap<>();
        //果然不用流更快一丢丢
        //Arrays.stream(strs).collect(Collectors.groupingBy(this::hash));
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            List<String> list = collect.computeIfAbsent(hash(str), k -> new LinkedList<>());
            list.add(str);
        }
        return new ArrayList<>(collect.values());
    }

    public int hash(String str){
        int h = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            h*= primes['z'-chars[i]];
        }
        return h;
    }
}
