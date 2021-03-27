package fly.leetcode.cn.q1116;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static cn.flython.utils.TimeStatisticsUtils.nanoEnd;
import static cn.flython.utils.TimeStatisticsUtils.nanoStart;
import static org.junit.jupiter.api.Assertions.*;

class ZeroEvenOddTest {


    @SneakyThrows
    @Test
    void zero() {
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
}