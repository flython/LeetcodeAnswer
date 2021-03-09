package fly.leetcode.cn.q1115;

/**
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 */
public class Q1115 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        FooBarLockSupport fooBar = new FooBarLockSupport(100);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("fooT");
        t2.setName("barT");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long l = System.nanoTime() - start;
        System.out.println();
        System.out.println(l);
    }
}
