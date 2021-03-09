package fly.leetcode.cn.q1115;


/**
 * 这会超出时间限制，应该是因为自旋和volatile刷入主内存耗费的时间比较高?
 * 但是奇怪的是，每次在本机测试，这个方法效率都是可以的（而且次数越多越快）
 * 100次测试
 * 最慢12ms 最快5ms JIT会在多次运行的时候进行编译吗？
 * 在本地测试中，加了yield反而效率变低了，但是在服务器提交中，不加yield就会超时，应该是服务器资源问题，
 * 由此可见，做题目真的只是做题目，并不能代表真实情况
 */
class FooBarVolatile {
    private int n;

    volatile boolean fooRun = true;
    volatile boolean barRun = false;


    public FooBarVolatile(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (barRun){
                //在本地测试中，加了yield反而效率变低了，但是在服务器提交中，不加yield就会超时
                Thread.yield();
            }
            barRun = true;
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooRun = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (fooRun){Thread.yield();}
            fooRun = true;
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            barRun = false;

        }
    }
}
