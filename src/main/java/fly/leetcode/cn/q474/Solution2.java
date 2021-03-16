package fly.leetcode.cn.q474;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/**
 * 背包问题，动态规划深度优先
 */
class Solution2 {
    static class Entry{
        int mCount;
        int nCount;
        public Entry(String str) {
            for (char c : str.toCharArray()) {
                if (c=='0'){++mCount;}else if (c == '1'){++nCount;}
            }
        }

        public static int sortByMAsc(Entry e1,Entry e2){
            int v = e1.mCount - e2.mCount;
            return v==0?e1.nCount - e2.nCount:v;
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        List<Entry> byM = Arrays.stream(strs).map(Entry::new).sorted(Entry::sortByMAsc).collect(Collectors.toList());
        return dfs(byM,1,0,m,n);
    }

    int dfs(List<Entry> list,int level,int start,int m, int n){
        if (start == list.size()){
            return level-1;
        }
        Entry e = list.get(start);
        int mRemain = m - e.mCount;
        int nRemain = n - e.nCount;
        if(mRemain < 0){
            return level-1;
        } else if (nRemain < 0){
            return dfs(list,level,start+1,m,n);
        } else {
            int include = dfs(list,level+1,start+1,mRemain,nRemain);
            int exclude = dfs(list,level,start+1,m,n);
            return Math.max(include,exclude);
        }
    }

}
