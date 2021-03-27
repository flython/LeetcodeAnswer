package fly.leetcode.cn.q1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * TODO 也是以前做的题目，有空可以重新做
 * n=1000
 * 运行时间16655000ns，大约为16ms
 * 运行时间17200400ns，大约为17ms
 * 运行时间16778400ns，大约为16ms
 * 运行时间16013300ns，大约为16ms
 * 运行时间24940500ns，大约为24ms
 *
 * 不使用yield:
 * 运行时间16511700ns，大约为16ms
 * 运行时间15468500ns，大约为15ms
 */
public class ZeroEvenOdd {
    private int n;
    volatile int flag = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; ++i) {
            while (flag != 0){
//                Thread.yield();
            }
            printNumber.accept(0);
            if ((i&1)==0){
                flag=1;
            } else {
                flag=2;
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int count = n/2;
        for (int i = 0; i < count; ++i) {
            while (flag != 2){
//                Thread.yield();
            }
            printNumber.accept((2*i)+2);
            flag = 0;

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int count = (n+1)/2;
        for (int i = 0; i < count; ++i) {
            while (flag != 1){
//                Thread.yield();
            }
            printNumber.accept((2*i)+1);
            flag = 0;
        }
    }
}