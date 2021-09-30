package fly.leetcode.cn.q517;

class Solution {
    public int findMinMoves(int[] machines) {
        //可能性检查
        float avg = 0;
        for (int machine : machines) {
            avg+=machine;
        }
        avg = ((float)avg / machines.length);
        if (((int) avg) != avg){
            return -1;
        }

        return 0;
    }
}