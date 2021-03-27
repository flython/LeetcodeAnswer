package fly.leetcode.support;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * 使用厄拉多塞筛法(Sieve of Eratosthenes) 生成素数
 *
 * 进阶：线性筛(欧拉筛)
 *      埃氏筛其实还是存在冗余的标记操作，比如对于 45 这个数，它会同时被 3与5 两个数标记为合数，因此我们优化的目标是让每个合数只被标记一次
 *      使用一个primes记录当前得到的质数集合
 *      对于从小到大的所有整数x，标记 x * primes[i] 直到 当x mod primes[i] == 0时结束标记
 *      上一步核心点在于，如果x可以被primes[i]整除，那么 x * primes[i+1] 一定也可以被 primes[i] 整除，所以没必要继续标记了
 *
 *      线性筛还有其他拓展用途，有能力的读者可以搜索关键字「积性函数」继续探究如何利用线性筛来求解积性函数相关的题目。
 *
 */
public class EratosthenesSievePrimes {

    public int[] getPrimes(int max){
        //使用bit来筛除非素数，为了优化首先排除所有偶数，标记1不是素数
        BitSet marker = new BitSet((max+1)>>1);
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
        //这里翻转时取+1为了包括max
        marker.flip(0,(max+1)>>1);
        return IntStream.concat(IntStream.of(2),marker.stream().map(i->(i<<1)+1)).toArray();
    }
}
