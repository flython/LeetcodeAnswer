package fly.leetcode.cn.q1482;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * 制作m束花
 * 使用相邻的k朵花
 */
class Solution {
    private int[] bloomDay;
    private int m;
    private int k;

    public int minDays(int[] bloomDay, int m, int k) {
        this.bloomDay = bloomDay;
        this.m = m;
        this.k = k;
        //考虑特殊结束情况
        if (bloomDay.length < m*k){return -1;}
        int min=0, max = Arrays.stream(bloomDay).max().getAsInt();
        while (min < max-1){
            int mid= (min + max)/2;
            if (check(mid)){
                max = mid;
            } else {
                min = mid;
            }
        }
        return max;
    }

    boolean check(int day){
        int used = 0;
        int count = 0;
        for (int i = 0, bloomDayLength = bloomDay.length; i < bloomDayLength; i++) {
            if (bloomDay[i] <= day){
                used++;
            }else {
                used = 0;
                continue;
            }
            if (used == k){
                used = 0;
                count++;
                if (count == m){
                    return true;
                }
            }
            if (bloomDayLength - i < (m-count-1) * k){
                return false;
            }
        }
        return false;
    }
}
