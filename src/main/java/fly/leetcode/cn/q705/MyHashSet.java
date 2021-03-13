package fly.leetcode.cn.q705;

import java.util.BitSet;
import java.util.LinkedList;

class MyHashSet {

    //一开始以为需要计算size，结果发现题目不需要，但是发现拿掉size运行速度更慢了，leetcode的系统太神奇
    int size = 0;
    // 既然key只有int，那简单粗暴上bitmap，测试发现bitset这个实现初始化大小15的时候运算速度最快（leetcode很神奇不知道为啥）
    BitSet bitSet = new BitSet(1 << 15);

    /** Initialize your data structure here. */
    public MyHashSet() {
    }

    public void add(int key) {
        size++;
        bitSet.set(key,true);
    }

    public void remove(int key) {
        size--;
        bitSet.set(key,false);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bitSet.get(key);
    }
}
