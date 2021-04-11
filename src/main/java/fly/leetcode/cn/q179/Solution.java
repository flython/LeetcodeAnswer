package fly.leetcode.cn.q179;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * 贪心？每次都找局部最优解
 * 每次都比较s1+s2与s2+s1
 */
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder collect = Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((s1, s2) -> -(s1+s2).compareTo(s2+s1))
                .collect(StringBuilder::new, (sb, s) -> sb.append(s), (a, b) -> {});
        while (collect.length() >= 2 && collect.charAt(0)=='0' && collect.charAt(1)=='0'){
            collect.deleteCharAt(0);
        }
        return collect.toString();
    }
}