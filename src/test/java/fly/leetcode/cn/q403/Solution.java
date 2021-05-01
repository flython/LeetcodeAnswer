package fly.leetcode.cn.q403;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 深度优先搜索+剪枝
 * 淦哦，能用，但是超时了，因为假如最后一个石头特别长
 */
class Solution {
    //记录某个pos上不可达的位置

    HashMap<Integer,HashSet<Integer>> markCanNot;
    Set<Integer> stones;
    int last;

    public boolean canCross(int[] stones) {
        this.stones = Arrays.stream(stones).boxed().collect(Collectors.toSet());
        markCanNot = new HashMap<>();
        last = stones[stones.length-1];
        return dfs(0,1);
    }

    private boolean dfs(int stone, int step){
        int next = stone + step;
        if (next == last){return true;}
        if (markCanNot.computeIfAbsent(step,HashSet::new).contains(step)){
            return false;
        }
        if (stones.contains(stone+step)){
            return dfs(next,step+1) || dfs(next,step) || (step > 1 && dfs(next,step-1));
        } else {
            markCanNot.computeIfAbsent(stone,HashSet::new).add(step);
            return false;
        }
    }
}