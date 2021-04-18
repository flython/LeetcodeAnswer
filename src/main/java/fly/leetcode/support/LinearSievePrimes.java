package fly.leetcode.support;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * 进阶：线性筛(欧拉筛)
 *      厄拉多塞筛其实还存在冗余的是标记操作，比如对于 45 这个数，它会同时被 3与5  两个数标记为合数，因此我们优化的目标是让每个合数只被标记一次
 *      使用一个primes记录当前得到的质数集合
 *      对于从小到大的所有整数x，标记 x * primes[i] 直到 当x mod primes[i] == 0时结束标记
 *      上一步核心点在于，如果x可以被primes[i]整除，那么 x * primes[i+1] 一定也可以被 primes[i] 整除，所以没必要继续标记了
 *
 *      线性筛还有其他拓展用途，有能力的读者可以搜索关键字「积性函数」继续探究如何利用线性筛来求解积性函数相关的题目。
 *
 */
// TODO 待实现 https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
public class LinearSievePrimes {

    public int[] getPrimes(int max){
        //使用bit来筛除非素数，为了优化首先排除所有偶数，标记1不是素数
        BitSet marker = new BitSet((max+1)>>1);
        marker.set(0);

        return IntStream.concat(IntStream.of(2),marker.stream().map(i->(i<<1)+1)).toArray();
    }
}
