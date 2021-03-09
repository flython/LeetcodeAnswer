package fly.newcoder.q3;

public class Main {
    public static void main(String[] args) {
        Point[] arr = {
                new Point(3,2),
                new Point(6,3),
                new Point(8,4),
                new Point(3,5),
                new Point(5,6),
                new Point(7,6),
//                new Point(5,4),
//                new Point(8,7),
//                new Point(2,1),
                new Point(0,0),
                new Point(-1,-1),
                new Point(2,2),
        };


        Solution solution = new Solution();
        int max = solution.maxPoints(arr);
        System.out.printf("" + max);
    }

}

