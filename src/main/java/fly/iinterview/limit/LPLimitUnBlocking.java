package fly.iinterview.limit;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 无锁无额外线程令牌桶
 */
public class LPLimitUnBlocking {
    int cap;
    long rate;
    final AtomicInteger tokens = new AtomicInteger(0);
    final AtomicLong lastReqTime = new AtomicLong(System.currentTimeMillis());

    public LPLimitUnBlocking(int cap, long rate) {
        this.cap = cap;
        this.rate = rate;
    }

    public boolean tryAcquire(int n){
        this.refillTokens();
        int t;
        do {
            t = tokens.get();
            if (t < n){return false;}
        }while (! tokens.compareAndSet(t,t-n));
        return true;
    }

    private void refillTokens() {
        long lastTime = lastReqTime.get();
        int fills = (int) ((System.currentTimeMillis() - lastTime) / rate);
        if (fills > 0 && lastReqTime.compareAndSet(lastTime,lastTime + fills*rate)){
            int oldTokens;
            int nextTokens;
            do {
                oldTokens = tokens.get();
                nextTokens = Math.min(cap, oldTokens + fills);
            } while (!tokens.compareAndSet(oldTokens,nextTokens));
        }
    }
}
