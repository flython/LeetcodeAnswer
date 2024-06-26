package fly.leetcode.cn.q179;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 345
 * 34
 * 34534
 * 34345
 *
 * 33295
 * 33
 * 3329533
 * 3333295
 *
 * 改进思路
 * 1. 先按照第一个数字进行分堆，然后排序
 * 2. 排序规则：
 *      2.1 如果长度相等，则直接按照数字大小逆序
 *      2.2 如果长度不相等，把长的部分分成几份长度与短字符串相符的小字符串，然后分别按照此前规则比较，只要存在长字符串
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings,(s1, s2) -> {
            if (s1.length() == s2.length()){
                return s2.compareTo(s1);
            }
            return (s2 + s1).compareTo(s1 + s2);
        });
        StringBuilder collect = new StringBuilder();
        for (String string : strings) {
            collect.append(string);
        }
        return collect.charAt(0)=='0'?"0":collect.toString();
    }
}