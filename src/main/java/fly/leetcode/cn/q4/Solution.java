package fly.leetcode.cn.q4;

import java.net.Socket;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {


    /**
     * TODO:朴素面向过程锻炼 (未完成)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 0){return handleOneIsBlank(nums2);}
        else if (length2 == 0) {return handleOneIsBlank(nums1);}


        int allLength =  length2 + length2;
        int mid = (allLength-1) / 2;
        int p1 = 0, p2 = 0;
        for (int i = 0; i <= mid; i++) {
            int checkVal1 = p1 < length1? nums1[p1] : Integer.MAX_VALUE;
            int checkVal2 = p2 < length2? nums1[p2] : Integer.MAX_VALUE;

            if (checkVal1 < checkVal2){
                ++p1;
            }else {
                ++p2;
            }

        }

        return 0;
    }


    private double handleOneIsBlank(int[] ints){
        int length = ints.length;
        if ((length & 1) == 1){
            return (double) ints[length / 2];
        } else {
            int tar = length / 2;
            return 0.5 * (ints[tar -1] + ints[tar]);
        }
    }

    /**
     * java 8 流使用锻炼。
     * 看来有必要刻意地考虑使用流
     */
    double stream(int[] nums1, int[] nums2) {
        int[] ints = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();

        int length = ints.length;
        if ((length & 1) == 1){
            return (double) ints[length / 2];
        } else {
            int tar = length / 2;
            return 0.5 * (ints[tar -1] + ints[tar]);
        }

    }


    public static void main(String[] args) {
        int[] a = {1,3};
        int[] b = {2,4};
        double v = new Solution().findMedianSortedArrays(a, b);
        System.out.println(v);
    }
}
