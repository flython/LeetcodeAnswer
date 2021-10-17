package tmp;

class Solution2 {
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        int orMax = 0;
        int orMaxNeg = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0){
                orMax |= num;
            } else {
                orMaxNeg  = Math.max(orMaxNeg,num);
            }
        }
        if (orMax == 0 && orMaxNeg != Integer.MIN_VALUE){
            orMax = orMaxNeg;
        }
        btc(orMax,nums,0,0);
        return count;
    }

    void btc(int target, int[] nums, int pos, int cur){
        if (pos >= nums.length){
            return;
        }

        int next = cur | nums[pos];
        if (next == target){
            count++;
        }
        //选
        btc(target,nums,pos+1,next);
        //不选
        btc(target,nums,pos+1,cur);
    }
}
