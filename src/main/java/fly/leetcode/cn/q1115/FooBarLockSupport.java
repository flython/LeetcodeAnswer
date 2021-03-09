package fly.leetcode.cn.q1115;

import java.util.concurrent.locks.LockSupport;

/**
 * n = 100
 * LockSupport的实现连一个测试用例都不能通过，但是在测试中
 * 第一次运行最慢是15ms-12ms，预热后可以在7.6到9.2ms之间，效率比不上纯volatile，但是我觉得也可以接受
 * 主要是这个实现并不是取巧，而是有真正的线程挂起
 */
class FooBarLockSupport {
    private int n;
    private volatile Thread parking;

    public FooBarLockSupport(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        Thread ft = Thread.currentThread();
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            Thread p = parking;
            parking = ft;
            LockSupport.unpark(p);
            LockSupport.park();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        Thread bt = Thread.currentThread();
        parking = bt;
        for (int i = 0; i < n; i++) {
            LockSupport.park();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            Thread p = parking;
            parking = bt;
            LockSupport.unpark(p);
        }
    }
}
