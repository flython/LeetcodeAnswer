package fly.leetcode.cn.q706;

import java.util.BitSet;

class MyHashMap {

    //bucket个数，飘忽不定的执行用时
    public static final int hashBit = 12;
    public static final int firstHashAnd = -1 >>> (32-hashBit);
    public static final int secHashAnd = 0b11111;
    BitSet bitSet = new BitSet(1<<15);
    int[][][] values = new int[firstHashAnd +1][][];
    /** value will always be non-negative. */

    private int secIndex(int key){
        return (key >> hashBit)&secHashAnd;
    }
    public void put(int key, int value) {
        int[][] bucket = getBucket(key);
        int index = secIndex(key);
        if (bitSet.get(key)){
            int[] node = bucket[index];
            for (int j = 0, bucketLength = node.length; j < bucketLength; j+=2) {
                if (node[j] == key){
                    node[j+1] = value;
                    break;
                }
            }
        } else {
            // not exist
            if(bucket[index] == null){
                // init bucket
                bucket[index] = new int[]{key,value};
            } else {
                int[] node = bucket[index];
                int oldLen = node.length;
                bucket[index] = new int[oldLen + 2];
                System.arraycopy(node,0, bucket[index],0, oldLen);
                bucket[index][oldLen] = key;
                bucket[index][oldLen+1] = value;
            }
            bitSet.set(key);
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int[][] bucket = getBucket(key);
        if (bitSet.get(key)){
            int[] node = bucket[secIndex(key)];
            for (int j = 0, bucketLength = node.length; j < bucketLength; j+=2) {
                if (node[j] == key){
                    return node[j+1];
                }
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int[][] bucket = getBucket(key);
        if (bitSet.get(key)){
            int index = secIndex(key);
            int[] node = bucket[index];
            for (int j = 0, bucketLength = node.length; j < bucketLength; j+=2) {
                if (node[j] == key){
                    if (bucketLength == 2){
                        bucket[index] = null;
                    } else {
                        bucket[index] = new int[bucketLength - 2];
                        System.arraycopy(node,0, bucket[index],0,j);
                        System.arraycopy(node,j+2, bucket[index],j,bucketLength-j-2);
                    }
                }
            }
            bitSet.set(key,false);
        }
    }

    private int[][] getBucket(int key){
        if (values[key & firstHashAnd] == null){
            values[key & firstHashAnd] = new int[secHashAnd+1][];
        }
        return values[key & firstHashAnd];
    }
}
