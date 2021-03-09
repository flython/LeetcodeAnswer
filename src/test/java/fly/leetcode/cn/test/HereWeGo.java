package fly.leetcode.cn.test;


import fly.leetcode.cn.q1116.ZeroEvenOdd;
import fly.leetcode.cn.q365.Solution;
import org.junit.Test;

import static cn.flython.utils.TimeStatisticsUtils.nanoEnd;
import static cn.flython.utils.TimeStatisticsUtils.nanoStart;


public class HereWeGo {

    @Test
    public void q1116() throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(1000);

        Thread t1 = new Thread(()->{
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        nanoStart();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        nanoEnd();
    }

    @Test
    public void q365(){
        Solution solution = new Solution();
        System.out.println(solution.canMeasureWater(13,11,1));
    }


}
