package fly.iinterview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAddrTest {

    private static final int MAX_POOL_SIZE = 1000;
    private static final int MAX_LOOP_SIZE = 1000;

    private static LongAdder longAdder = new LongAdder();
    private static AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
//        atomicLongTest();
        longAdderTest();
    }

    /**
     * @author: 栈长
     * @from: 公众号Java技术栈
     */
    private static void longAdderTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(MAX_POOL_SIZE);
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            es.execute(() -> {
                for (int j = 0; j < MAX_LOOP_SIZE; j++) {
                    longAdder.increment();
                }
            });
        }


        es.shutdown();
        es.awaitTermination(5, TimeUnit.MINUTES);
        System.out.printf("LongAdder %s*%s 结果：%s，耗时：%sms.\n",
                MAX_POOL_SIZE,
                MAX_LOOP_SIZE,
                0,
                (System.currentTimeMillis() - start));
    }

    /**
     * @author: 栈长
     * @from: 公众号Java技术栈
     */
    private static void atomicLongTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(MAX_POOL_SIZE);
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            es.execute(() -> {
                for (int j = 0; j < MAX_LOOP_SIZE; j++) {
                    atomicLong.incrementAndGet();
                }
            });
        }

        es.shutdown();
        es.awaitTermination(5, TimeUnit.MINUTES);
        System.out.printf("AtomicLong %s*%s 结果：%s，耗时：%sms.\n",
                MAX_POOL_SIZE,
                MAX_LOOP_SIZE,
                0,
                (System.currentTimeMillis() - start));
    }
}
