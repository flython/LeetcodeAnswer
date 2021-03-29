package fly.leetcode.cn.q131;

import java.util.*;

/**
 * 感觉是 经典动态规划
 * aabcb
 *
 * a=       a
 * aa=      a,a | aa
 * aab=     a,a,b | aa,b
 * aabc=    a,a,b,c | aa,b,c
 * aabcd=   a,a,b,c,b | aa,b,c,b | a,a,bcb | aa, bcb
 *
 * a
 * 每增加一个字符
 * 1 现有的回文组里所有单独加上单个新字符
 * 2 现有的回文组里，最后一个回文串加上新字符看看是不是回文
 * 3 从后开始往前遍历，如果找到回文串，则剩下字符串部分对应的所有回文串，加上新的尾序列回文串（此步骤包括2）
 * 动态规划，做是做出来了，但是为啥这么慢呢，思路错了
 */
class Solution {
    public List<List<String>> partition(String s) {
        HashMap<String, List<List<String>>> markBook = new HashMap<>();
        var subBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        subBuilder.append(chars[0]);
        String pre = subBuilder.toString();
        markBook.put("",List.of(Collections.emptyList()));
        markBook.put(pre,List.of(List.of(pre)));
        for (int i = 1; i < chars.length; i++) {
            //放入最新字符
            String newChar = String.valueOf(chars[i]);
            subBuilder.append(newChar);
            var current = subBuilder.toString();
            //1 现有的回文组里所有单独加上单个新字符
            List<List<String>> currentSubs = markBook.computeIfAbsent(current,k->new LinkedList<>());
            for (List<String> preSubArr : markBook.get(pre)) {
                ArrayList<String> curSubArr = new ArrayList<>(preSubArr.size() + 1);
                curSubArr.addAll(preSubArr);
                curSubArr.add(newChar);
                currentSubs.add(curSubArr);
            }
            //3 从后开始往前遍历，如果找到回文串，则剩下字符串部分对应的所有回文串，加上新的尾序列回文串（此步骤包括2）
            for (int j = current.length() - 2; j >= 0; j--) {
                String endSub = subBuilder.substring(j);
                if (isPalindromeString(endSub)){
                    for (List<String> preSubArr : markBook.get(subBuilder.substring(0,j))) {
                        ArrayList<String> curSubArr = new ArrayList<>(preSubArr.size() + 1);
                        curSubArr.addAll(preSubArr);
                        curSubArr.add(endSub);
                        currentSubs.add(curSubArr);
                    }
                }
            }
            pre = current;
        }
        return markBook.get(s);
    }

    private boolean isPalindromeString(String str){
        int length = str.length();
        for (int i = 0; i < length /2; i++) {
            if (str.charAt(i)!=str.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
}
