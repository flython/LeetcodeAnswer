package fly.leetcode.cn.q80;

/**
 * 也就是说需要把相同的数字删除到只剩下两个咯
 */
class SolutionStupid {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len;) {
            int k = i+1;
            while (k < len && nums[k] == nums[i]){
                ++k;
            }
            //此时k指向第一个不相等的元素
            if (k <= i+2){
                i=k;
            } else {
                System.arraycopy(nums,k,nums,i+2,len-k);
                len-=(k-i-2);
                i+=2;
            }
        }
        return len;
    }
}
