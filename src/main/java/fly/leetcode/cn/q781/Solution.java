package fly.leetcode.cn.q781;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 还需要考虑
 * [1,1,1]
 * 这种情况，有两个1可以组队，但是另外一个1是单独的需要单独统计；
 */
class Solution {
    public int numRabbits(int[] answers) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0){
                ++sum;
            }else {
                Integer count = map.getOrDefault(answers[i], 0);
                map.put(answers[i],count+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int weight = entry.getKey()+1;
            int count = entry.getValue();
            sum += Math.ceil((double) count/weight)*weight;
        }
        return sum;
    }
}
