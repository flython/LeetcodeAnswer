package fly.leetcode.cn.q1436;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 `paths` 表示，
 * 其中 `paths[i] = [cityAi, cityBi]` 表示该线路将会从 `cityAi` 直接前往 `cityBi`
 * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市
 *
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 * 困难题唯唯诺诺，简单题重拳出击
 * 流api比普通写法多了3ms，但是千金难买我写得爽
 */

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> collect = paths.stream()
                .collect(Collectors.toMap(p -> p.get(0), p -> p.get(1)));
        return collect.values().stream()
                .filter(Predicate.not(collect::containsKey))
                .findAny().get();
    }
}