package fly.leetcode.cn.q1115;

import java.util.concurrent.Semaphore;

/**
 * 虽然网页正常通过
 * 100次测试中
 * 但是在本机测试中效率是最低的，最慢15ms，最快也是快到10ms
 */
class FooBarSemaphore {
    private int n;

    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);


    public FooBarSemaphore(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (semaphore.availablePermits()>0){}
            semaphore2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore.release();

        }
    }
}
