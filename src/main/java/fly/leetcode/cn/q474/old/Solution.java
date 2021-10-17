package fly.leetcode.cn.q474.old;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 不是很能整懂动态规划该怎么做，
 *
 * 分析， 1 先处理strs 中的 0 和 1的数量，按照数量从大到小排成两个数组
 *       2 分别处理两个数组，去掉最大值，看看是否能满足[m,n]，如果不行，则用去掉后的数组继续处理刚才的操作，直到找到符合规则为止
 *       3 比较两次分别处理的值，返回更大的一个。
 */
class Solution {
    static class Entry{
        int mCount;
        int nCount;
        public Entry(String str) {
            for (char c : str.toCharArray()) {
                if (c=='0'){++mCount;}else if (c == '1'){++nCount;}
            }
        }
        public static int sortByM(Entry e1,Entry e2){
            int v = e2.mCount - e1.mCount;
            return v==0?e2.nCount - e1.nCount:v;
        }

        public static int sortByN(Entry e1,Entry e2){
            int v = e2.nCount - e1.nCount;
            return v==0?e2.mCount - e1.mCount:v;
        }

    }
    public int findMaxForm(String[] strs, int m, int n) {
        List<Entry> byM = Arrays.stream(strs).map(Entry::new).sorted(Entry::sortByM).collect(Collectors.toList());
        if (checkBothUnder(byM,m,n)){
            return byM.size();
        }
        List<Entry> byN = byM.stream().sorted(Entry::sortByN).collect(Collectors.toList());

        byM.remove(0);
        byN.remove(0);
        while (byM.size() > 0){
            if (checkBothUnder(byM, m, n)){
                return byN.size();
            }
            if (checkBothUnder(byN, m, n)){
                return byN.size();
            }
            byM.remove(0);
            byN.remove(0);
        }
        return 0;
    }

    public boolean checkBothUnder(List<Entry> list, int m, int n){
        for (Entry entry : list) {
            m-= entry.mCount;
            if (m < 0){
                return false;
            }
            n-=entry.nCount;
            if (n < 0){
                return false;
            }
        }
        return true;
    }
}
