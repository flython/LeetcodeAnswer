package fly.leetcode.cn.q1116;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;


/**
 * 超出时间限制，n=1000
 * 运行时间38093000ns，大约为38ms
 * 运行时间34331600ns，大约为34ms
 * 运行时间33971200ns，大约为33ms
 */
public class ZeroEvenOddLockSupport {
    private int n;
    volatile Thread t0,t1,t2;
    Semaphore semaphore = new Semaphore(1);

    public ZeroEvenOddLockSupport(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        t0=Thread.currentThread();
        for (int i = 0; i < n; ++i) {
            semaphore.acquire();
            printNumber.accept(0);
            if ((i&1)==0){
                LockSupport.unpark(t1);
            } else {
                LockSupport.unpark(t2);
            }
            semaphore.release();
            LockSupport.park();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        t2 = Thread.currentThread();
        int count = n/2;
        for (int i = 0; i < count; ++i) {
            LockSupport.park();
            semaphore.acquire();
            printNumber.accept((2*i)+2);
            semaphore.release();
            LockSupport.unpark(t0);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        t1 = Thread.currentThread();
        int count = (n+1)/2;
        for (int i = 0; i < count; ++i) {
            LockSupport.park();
            semaphore.acquire();
            printNumber.accept((2*i)+1);
            semaphore.release();
            LockSupport.unpark(t0);
        }
    }
}