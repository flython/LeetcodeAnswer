package fly.leetcode.cn.q90;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 注：本做法使用动态规划，自己写的做法1
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 13.42% 的用户
 * 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 17.41% 的用户
 * TODO 研究更快的解法
 *
 * 动态规划：
 *      每添加一个nums，子集 相当于 之前所有子集 + 之前所有子集加上新增元素
 *      1       [],[1]
 *      1 2     [],[1],[2],[1,2]
 *      1 2 1   [],[1],[2],[1,2],[1,1],[1,2,1]
 *      1212    [],[1],[2],[1,2],[1,1]
 * 深度优先
 *      逐个减少数字 122
 *      减少0个 122
 *      减少1个 22，12
 *      减少2个 2，1
 *      减少3个 []
 *
 *      12123
 *      0       12123
 *      1       2123，1123，1212
 *      2       123，223，212，113，112
 *      3       23，12，13，22，11
 *      4       3，2，1
 *      5       []
 */
class Solution {
    //使用质数映射搭配乘法，可以保证不重复
    public static int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79};

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer,List<Integer>> subSet = new HashMap<>();
        subSet.put(1,Collections.emptyList());
        for (int i = 0; i < nums.length; i++) {
            Map<Integer,List<Integer>> newSubSets = new HashMap<>();
            int num = nums[i];
            for (Map.Entry<Integer, List<Integer>> entry : subSet.entrySet()) {
                int oldHash = entry.getKey();
                int newHash = oldHash *= primes[num +10];
                if (subSet.containsKey(newHash)||newSubSets.containsKey(newHash)){
                    continue;
                }
                var newSubSet = new LinkedList<>(entry.getValue());
                newSubSet.add(num);
                newSubSets.put(newHash,newSubSet);
            }
            subSet.putAll(newSubSets);
        }
        return new ArrayList<>(subSet.values());
    }

}