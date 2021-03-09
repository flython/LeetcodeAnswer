package fly.leetcode.cn.q1116;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * n=1000
 * 运行时间38208700ns，大约为38ms
 * 运行时间39228800ns，大约为39ms
 */
public class ZeroEvenOddLock {
    private int n;
    ReentrantLock lock0 = new ReentrantLock();
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    Condition c0 = lock0.newCondition();
    Condition c1 = lock1.newCondition();
    Condition c2 = lock2.newCondition();

    public ZeroEvenOddLock(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; ++i) {
            lock0.lock();
            printNumber.accept(0);
            if ((i & 1) == 0){
                lock1.lock();
                c1.signalAll();
                lock1.unlock();
            } else {
                lock2.lock();
                c2.signalAll();
                lock2.unlock();
            }
            c0.await();
            lock0.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int count = n/2;
        for (int i = 0; i < count; ++i) {
            lock2.lock();
            c2.await();
            printNumber.accept((2*i)+2);
            lock0.lock();
            c0.signalAll();
            lock0.unlock();
            lock2.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int count = (n+1)/2;
        for (int i = 0; i < count; ++i) {
            lock1.lock();
            c1.await();
            printNumber.accept((2*i)+1);
            lock0.lock();
            c0.signalAll();
            lock0.unlock();
            lock1.unlock();
        }
    }
}