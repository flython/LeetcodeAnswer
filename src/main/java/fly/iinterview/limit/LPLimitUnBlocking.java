package fly.iinterview.limit;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 无锁无额外线程令牌桶算法
 * 主要思路是延迟填充+cas
 * 1. 获取令牌前，先进行填充操作
 *  1. 填充时，先使用使用上次更新时间、更新频率、当前时间计算出应该填充的的数量
 *  2. 首先尝试使用cas更新上次补充时间，更新失败说明已经有其他线程更新令牌，此时可以直接退出填充
 *  3. 当更新补充时间成功后，此时说明当前线程已经获得了补充该次令牌数量的机会，通过自旋+cas更新令牌数量为 【应增加】 + 【现有】，此处必须自选到更新成功为止
 *  4. 注意【应增加】 + 【现有】 大于容量时，更新为最大容量
 * 2. 填充完毕后，获取当前令牌桶中有的令牌数量，如果令牌不足则退出获取，如果令牌充足则通过cas更新现有令牌数量，若更新失败则自旋到令牌不足或更新成功为止
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
        } while (! tokens.compareAndSet(t,t-n));
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
