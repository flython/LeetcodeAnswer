package fly.newcoder.q2;

public class Main {
    public static void main(String[] args) {
        String[] a = {"4", "13", "5", "/", "+"};
        Integer res = new Solution().evalRPN(a);
        System.out.println(res);
    }
}
