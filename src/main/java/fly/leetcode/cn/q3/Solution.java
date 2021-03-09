package fly.leetcode.cn.q3;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 执行用时： 17 ms , 在所有 Java 提交中击败了 22.84% 的用户 内存消耗： 40.3 MB , 在所有 Java 提交中击败了 5.20% 的用户
 * 我好菜呀
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        return arr(s);
    }


    //TODO:
    public int arr(String s) {
        int[] countChar = new int[128];
        int max = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
//            if (countChar[c] > 0){
//            }
            max = Math.max(i - countChar[c],max);
            countChar[c] = i;
        }
        if (max==0){
            max = s.length();
        }
        return max;
    }


    public int set(String s) {
        int max = 0;
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)){
                max = Math.max(set.size(),max);
                Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()){
                    Character character = iterator.next();
                    iterator.remove();
                    if(character.equals(c)){
                        break;
                    }
                }
            }
            set.add(c);
        }
        max = Math.max(set.size(),max);
        return max;
    }





    public static void main(String[] args) {
        int length = new Solution().lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }
}
