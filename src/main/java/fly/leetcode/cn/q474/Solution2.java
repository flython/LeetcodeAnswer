package fly.leetcode.cn.q474;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 双限制背包问题
 * 自下而上 填表法 是循环填表
 * 自上而下 记忆法 是进行结果记忆
 * （但是因为有两个限制条件，所以子问题选择了什么会影响到另一个控制条件的选择），那也还是需要三维数组？
 */
class Solution2 {
    static class Item {
        int m;
        int n;
        public Item(String str) {
            for (char c : str.toCharArray()) {
                if (c=='0'){++m;}else if (c == '1'){++n;}
            }
        }

        public static int sortByMAsc(Item e1, Item e2){
            int v = e1.m - e2.m;
            return v==0?e1.n - e2.n :v;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "m=" + m +
                    ", n=" + n +
                    '}';
        }
    }

    List<Item> items;


    public int findMaxForm(String[] strs, int m, int n) {
        items = Arrays.stream(strs).map(Item::new).sorted(Item::sortByMAsc).collect(Collectors.toList());
        //置入空元素
        items.add(0,new Item(""));
        return findAsM(items,m,n);
    }

    public int findAsM(List<Item> items, int m, int n){
        //子数组中0为m的值，1为n的值，2为当前已放入数量
        // 默认已经全部初始化为0
        int rem[][] = new int[m+1][3];
//        for (int i = 0; i < m; i++) {
//            rem[i] = new int[2]
//        }

        //开始填表
        for (int i = 1; i < items.size(); i++) {
            Item item = items.get(i);
            for (int j = m; j >= 0; j--) {
                //当前m限制下装不进去(
                // 限制条件： m不满足放入
                //        : 或m满足放入，但查表得知放入后n超标
                if (j < item.m || n-rem[j- item.m][1] < item.n){
                    //直接继承数组中原来的值
                } else {
                    //找到能放入的上一个状态
                    int[] pre = rem[m-j];
                    //修改当前m值对应的状态
                    int[] tar = rem[j];
                    //还需要对比计算后的与原来值哪个更优（计算后的n更大，同大m更小，同大n更小）

                    // 新的m值
                    int count1 = pre[2]+1;
                    int m1 = item.m + pre[0];
                    int n1 = item.n + pre[1];
                    // 新的n值
                    if (count1 > tar[2] ||
                        (count1 == tar[2] && m1 < tar[0]) ||
                        (count1 == tar[2] && m1 == tar[0] && n1 < tar[1])
                    ){
                        tar[0] = m1;
                        tar[1] = n1;
                        tar[2] = count1;
                    }
                }
            }
        }
        // 返回右下角的数量
        return rem[m][2];

    }

}
