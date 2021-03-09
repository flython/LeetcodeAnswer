package fly.leetcode.cn.q125;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
    public boolean isPalindrome(String s) {
        return directCheck(s);
    }



    private boolean directCheck(String s){
        int step = 'a' - 'A';
        char[] chars = s.toCharArray();
        int i = 0;
        int k = chars.length-1;
        while (i < k){
            char c = chars[i];
            while (! ((c >= 'a' && c <= 'z')||(c >= '0' && c <= '9')||(c >= 'A' && c <= 'Z'))){
                if (++i > k ){
                    return true;
                } else {
                    c = chars[++i];
                }
            }

            char d = chars[k];
            while (! ((d >= 'a' && d <= 'z')||(d >= '0' && d <= '9')||(d >= 'A' && d <= 'Z'))){
                d = chars[--k];
            }

            if (c >= 'A' && c <= 'Z'){
                c = (char) (c+step);
            }

            if (d >= 'A' && d <= 'Z'){
                d = (char) (d+step);
            }

            if (d != c){
                return false;
            }
            ++i;--k;
        }
        return true;
    }


    /**
     *  执行用时 : 3 ms , 在所有 Java 提交中击败了 93.04% 的用户 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 7.14% 的用户
     */
    private boolean array(String s) {
        int step = 'a' - 'A';

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z')||(c >= '0' && c <= '9')){
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z'){
                sb.append((char)(c+step));
            }
        }
        char[] charArray = sb.toString().toCharArray();
        int length = charArray.length;
        for (int i = 0; i < (length+1)/2; i++) {
            if (charArray[i] != charArray[length-1-i]){
                return false;
            }
        }
        return true;
    }

    private boolean regex(String s){
        StringBuilder sb = new StringBuilder();
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            sb.append(matcher.group().toLowerCase());
        }
        return sb.toString().equals(sb.reverse().toString());
    }


    public static void main(String[] args) {
        boolean b = new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(b);
    }
}
