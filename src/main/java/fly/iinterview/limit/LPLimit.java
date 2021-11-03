package fly.iinterview.limit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 最简单令牌算法
 * 辅助线程令牌
 */
public class LPLimit {
    int cap;
    int tokens = 0;
    long rate;
    ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);

    public LPLimit(int cap, long rate) {
        this.cap = cap;
        this.rate = rate;
        scheduled.scheduleAtFixedRate(this::addToken,0,rate, TimeUnit.MILLISECONDS);
    }

    private synchronized void addToken(){
        if (tokens < cap){
            tokens++;
        }
    }

    private synchronized boolean tryAcquire(int n){
        if (tokens > n){
            tokens-=n;
            return true;
        }
        return false;
    }
}
