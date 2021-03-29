package fly.leetcode.cn.q190;

import java.util.HashMap;

public class SolutionCache {
    // you need treat n as an unsigned value
    HashMap<Integer,Integer> cache = new HashMap<>();
    // you need treat n as an unsigned value
    public int reverseBits(int i) {
        Integer c = cache.get(i);
        if (c!=null){return c;}
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        int res = (i << 24)            |
                ((i & 0xff00) << 8)  |
                ((i >>> 8) & 0xff00) |
                (i >>> 24);
        cache.put(res,i);
        cache.put(i,res);
        return res;
    }
}
