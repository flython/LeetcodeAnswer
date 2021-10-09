package fly.leetcode.cn.q352;

import java.util.BitSet;
import java.util.LinkedList;

class SummaryRanges {
    BitSet bitSet = new BitSet();

    public SummaryRanges() {

    }

    public void addNum(int val) {
        bitSet.set(val);
    }

    public int[][] getIntervals() {
        LinkedList<int[]> respList = new LinkedList<>();
        int index = 0;
        while (index != -1){
            int left = bitSet.nextSetBit(index);
            //右边再也没有新的设置的bit，具体看bitSet的Api
            if (left == -1){break;}
            int right = bitSet.nextClearBit(left);
            respList.add(new int[]{left,right-1});
            index = right;
        }
        return respList.toArray(new int[0][]);
    }
}


