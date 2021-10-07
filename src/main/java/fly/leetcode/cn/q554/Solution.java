package fly.leetcode.cn.q554;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> gapCountMap = new HashMap<>();
        for (List<Integer> row : wall) {
            int gapPtr = 0;
            for (Iterator<Integer> iterator = row.iterator();;) {
                Integer brick = iterator.next();
                //跳过最后一个
                if (!iterator.hasNext()){break;}
                gapPtr += brick;
                gapCountMap.compute(gapPtr, (k, original) -> original == null ? 1 : original + 1);
            }
        }
        return wall.size()-gapCountMap.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}