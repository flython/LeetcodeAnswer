package fly.leetcode.cn.q1025;

import java.util.HashMap;
import java.util.Map;

/**

 * 限制： 1 <= N <= 1000
 * 分析： 1. 本质，判断这是不是一个先手必胜的游戏，如果这个游戏状态是先手必胜（true），那必然是后手必输（false）
 *       2. 如果爱丽丝先手，那判断可不可以通过一个回合把游戏变成后手必输的状态
 *       3. (可以读取以前的缓存的情况下)先缓存所有后手必输的游戏状态n，随后拿到N后遍历判断 N % n == 0 ( 1<= n <= N/2 )，如果等式成立，则可以通过选择N-n把游戏变成后手必输
 *       4. (不能读取缓存的情况下)便利所有可能选择的n( 1<= n <= N/2 )，判断 N % n == 0 && F(N-n) == false，则可以通过选择N-n把游戏变成后手必输)
 *
 */

class Solution {

    Map<Integer,Boolean> markBook = new HashMap<>();


    public boolean divisorGame(int N) {
        //复用Solution的情况下加速游戏
        Boolean pre = markBook.get(N);
        if (pre != null){
            return pre;
        }

        boolean res = false;
        // 如果N==1 天然False
        if (N != 1) {
            //因数只能取到前半
            int halfN = N/2;
            for (int i = 1; i <= halfN; i++) {
                //如果是因数，且轮到对手时游戏局面为后手必输
                if ( N % i == 0 && !divisorGame(N-i)){
                    res = true;
                }
            }
        }

        markBook.put(N,res);
        return res;
    }
}
