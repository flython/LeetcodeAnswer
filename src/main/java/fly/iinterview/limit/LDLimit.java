package fly.iinterview.limit;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单漏桶算法
 * 漏桶算法的本质在于：强行限流
 */
public class LDLimit<T> {
    long rate;
    volatile long lastConsumer = System.currentTimeMillis();
    BlockingQueue<T> queue;

    public LDLimit(long rateMs, int cap) {
        this.rate = rateMs;
        queue = new ArrayBlockingQueue<>(cap);
    }

    public boolean produce(T data){
        return queue.offer(data);
    }

    public T consume() throws InterruptedException {
        T take = queue.take();
        try{
            long nextConsume = lastConsumer + rate;
            if (nextConsume > System.currentTimeMillis()) {
                LockSupport.parkUntil(nextConsume);
            }
            return take;
        } finally {
            lastConsumer = System.currentTimeMillis();
        }
    }
}
