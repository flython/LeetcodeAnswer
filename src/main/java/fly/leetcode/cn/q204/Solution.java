package fly.leetcode.cn.q204;

import fly.leetcode.support.EratosthenesSievePrimes;

import java.util.BitSet;

/**
 * 参考 {@link EratosthenesSievePrimes}
 */
class Solution {
    public int countPrimes(int max) {
        if (max <= 2){
            return 0;
        }
        BitSet marker = new BitSet((max)>>1);
        marker.set(0);

        int current = 3;
        //当最后筛选出来的素数的平方大于最大范围后，bitmap中剩余的未标记位全都是素数
        //这里取等于为了包括max
        while (current*current <= max){
            int multiple = current*3;
            while (multiple <= max){
                //排除为偶数的倍数
                if ((multiple & 1) == 1){
                    marker.set(multiple>>1);
                }
                multiple+=current;
            }
            //数字在bitmap中的映射关系为 index = num/2
            int markIndex = current>>1;
            //取下一个未标记的位置（该方法包含当前位置，所以位置需要先+1），随后倍增再+1反映射成未标记的奇数
            current = (marker.nextClearBit(markIndex+1)<<1)+1;
        }

        //通过翻转bit来获取所有素数，因为优化原因，标记表中没有偶数2的映射，结果记得加上2
        marker.flip(0,(max+1)>>1);
        return marker.cardinality()+ (marker.get(max>>1)?0:1);
    }
}
