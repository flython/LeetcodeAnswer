package fly.leetcode.cn.q4;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 数组两个 n1,n2
 * 如果两个数组一共有偶数个数字，2 * n中 = nums[(n1+n2)/2-1]  +  nums[(n1+n2)/2]
 * 如果两个数组一共有奇数个数字 n中 = num[(n1+n2)/2]
 */
class Solution2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length == 0 &&nums2.length == 0){
            return 0;
        }else if (nums1.length == 0){
        } else if (nums2.length == 0){

        }

        //首先要保证两个数组不为空

        int n1 = 0;
        int n2 = 0;
        int midPos = (nums1.length + nums2.length) / 2;

        Integer pre = null;
        Integer current = null;

        for (int i = 0; i <= midPos; i++) {
            pre = current;
            current = Math.min(nums1[n1], nums2[n2]);
            if (i == midPos){
                if (((nums1.length + nums2.length) & 1) == 0){
                    //偶数个
                    return (pre+current)/2.0;
                } else {
                    //奇数个
                    return current;
                }
            }
        }
        // not here;
        return current;
    }


}
