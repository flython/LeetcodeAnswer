package fly.iinterview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 漏斗算法
 */
public class LDLimit {
    private int capacity;//令牌桶容量
    private int rate;//产生令牌速率 ms
    private final AtomicInteger tokens;
    private final AtomicLong lastRefillTime;

    public LDLimit(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.tokens = new AtomicInteger(capacity);
        this.lastRefillTime = new AtomicLong(System.currentTimeMillis());
    }

    public boolean tryAcquire(int n){
       this.refillToken(n,System.currentTimeMillis());
       return consumeToken(n);
    }

    private boolean consumeToken(int n) {
        int current = tokens.get();
        do {
            if (current < n){return false;}
        } while (!tokens.compareAndSet(current,current - n));
        return true;
    }

    private void refillToken(int n, long currentTimeMillis) {
        long lastTime = lastRefillTime.get();
        long timeDelta = currentTimeMillis - lastTime;
        int newToken = (int) (timeDelta / rate);
        if (newToken > 0){
            if (lastRefillTime.compareAndSet(lastTime,lastTime+newToken*rate)) {
                int current;
                int next;
                do {
                    current = tokens.get();
                    next = Math.max(capacity,current+newToken);
                } while (!tokens.compareAndSet(current,next));
            }
        }
    }
}
