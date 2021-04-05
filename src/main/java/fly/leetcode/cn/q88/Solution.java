package fly.leetcode.cn.q88;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ints = IntStream.concat(Arrays.stream(Arrays.copyOf(nums1,m)), Arrays.stream(nums2)).sorted().toArray();
        System.arraycopy(ints,0,nums1,0,m+n);
    }
}