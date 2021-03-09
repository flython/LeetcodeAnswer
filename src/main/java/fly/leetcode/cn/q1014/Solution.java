package fly.leetcode.cn.q1014;

import java.io.*;

class Solution {

    //TODO： 未完成
    public int maxScoreSightseeingPair(int[] A) {
        return dynamic(A);
    }

    public int violence(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int val = arr[i] + arr[j] - (j-i);
                max = Math.max(max,val);
            }
        }

        return max;
    }

    public int dynamic(int[] arr){
        int p0 = 0,p1 = 1;
        int max = arr[p0] + arr[p1] - (p1-p0);
        if (arr.length < 3){
            return max;
        }
        for (int i = 2; i < arr.length; i++) {
            int v1 = arr[p0] + arr[i] - (i-p0);
            int v2 = arr[p1] + arr[i] - (i-p1);

            int orginP1 = p1;
            if (v1 > max || v2 > max){
                if (v1 > v2){
                    max = v1;
                } else {
                    p0 = p1;
                    max = v2;
                }
                p1 = i;
            }

            //这个遍历也超出时间限制了
            for (int j = orginP1 + 1; j < i; ++j){
                int v = arr[j] + arr[i] - (i-j);
                if (v > max){
                    p0 = j;
                    p1 = i;
                    max = v;
                }
            }
        }

        System.out.println("p0:" + p0);
        System.out.println("p1:" + p1);
        return max;
    }


    public static void main(String[] args) throws IOException {

        File file = new File("E:\\A.CodeWorkspace\\LeetcodeAnswer\\src\\main\\java\\fly\\leetcode\\cn\\q1014\\array");
        BufferedReader bfr = new BufferedReader(new FileReader(file));
        String s = bfr.readLine();
        String[] split = s.split(",");

        int[] arr2 = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            arr2[i] = Integer.valueOf(s1).intValue();
        }

        int[] arr = {7,2,6,6,9,4,3}; //结果应该是要15
        int i = new Solution().maxScoreSightseeingPair(arr2);
        System.out.println(i);
    }
}
