package fly.leetcode.cn.q70;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


class Solution {

    int solveCount = 0;

    public int climbStairs(int input) {
        if (input <= 2){
            return input;
        }
        return dynamicProgramming(input-1) + dynamicProgramming(input-2);
    }

//    ConcurrentHashMap<Integer,Integer> resMap = new ConcurrentHashMap<>();
    int[] resArr = new int[47];
    //递归式的动态规划+缓存，减少计算次数
    int dynamicProgramming(int input){
        if (input <= 2){
            return input;
        }
        int res = resArr[input];
        if (res < 1){
            res = dynamicProgramming(input-1) + dynamicProgramming(input-2);
            resArr[input] = res;
        }
        return res;

    }

    /**
     * 这种递归，实际上就是穷解而已，有很多重复运算
     */
    void recursive(int left){
        if (left == 1 || left == 0){
            solveCount++;
        } else {
            recursive(left-1);
            recursive(left-2);
        }
    }

    public static void main(String[] args) {
        int i = new Solution().climbStairs(44);
        System.out.println(i);
    }
}

