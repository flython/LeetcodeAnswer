package fly.leetcode.offer2.q069;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-1;
        while (l<r){
            int mid = (r+l)/2;
            int lm = arr[mid] - arr[mid-1];
            int rm = arr[mid+1] - arr[mid];
            if (lm >0 && rm >0){
                l = mid;
            } else if (lm < 0 && rm <0) {
                r = mid;
            } else {
                return mid;
            }
        }
        return l;
    }
}
