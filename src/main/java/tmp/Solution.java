package tmp;

class Solution {
    public boolean areNumbersAscending(String s) {
        int pre = -1;
        String[] split = s.split(" ");
        for (String s1 : split) {
            try{
                Integer v = Integer.valueOf(s1);
                if (v <= pre){
                    return false;
                }
                pre = v;
            } catch (Throwable ignore){}
        }
        return true;
    }
}