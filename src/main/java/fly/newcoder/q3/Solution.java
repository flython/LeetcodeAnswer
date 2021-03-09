package fly.newcoder.q3;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int maxPoints(Point[] points) {
        int arrLength = points.length;
        if (arrLength < 2){
            return  arrLength;
        }

        HashMap<Integer, Integer> counterMap = new HashMap<>();
        HashMap<LinearGeneralEquation, Integer> counterMap2 = new HashMap<>();
        LinkedList<LinearGeneralEquation> existLine = new LinkedList();
        for (int i = 0; i < arrLength; ++i) {
            for (int j = i+1; j < arrLength; ++j) {
                LinearGeneralEquation line = new LinearGeneralEquation(points[i],points[j]);
                Integer index;
                if((index = existLine.indexOf(line)) >= 0){
//                    if (index == 4)
//                    System.out.println(points[i].toString() + "and" + points[j].toString());
                    if(counterMap.containsKey(index)){
                        counterMap.put(index,counterMap.get(index) + 1);
                    }else{
                        counterMap.put(index,1);
                    }
                } else {
                    existLine.add(line);
                }

                if(counterMap2.containsKey(line)){
                    counterMap2.put(line,counterMap2.get(line) + 1);
                }else{
                    counterMap2.put(line,1);
                }



            }
        }

        int maxLine=0;
        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            int value = entry.getValue();
            if (value > maxLine){
                maxLine = value;
            }
        }

        maxLine = maxLine+1;

        int i = 2;
        while (true){
            int tmp = combination(i);
            if (tmp == maxLine){
                return i;
            }

            ++i;
        }

    }

    private int combination(int i){
        if (i == 2){
            return 1;
        }
        return i * (i - 1) >> 1;
    }

    public class LinearGeneralEquation{
        int A;
        int B;
        int C;

        LinearGeneralEquation(Point p1, Point p2){
            this.A = p2.y - p1.y;
            this.B = p1.x - p2.x;
            this.C = p1.y * p2.x - p1.x*p2.y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof LinearGeneralEquation){
                LinearGeneralEquation p2 = (LinearGeneralEquation) obj;
                if (C == 0 && p2.C == 0){
                    return  A*p2.B == B*p2.A;
                }
                int t1 = A*p2.B*p2.C;
                int t2 = p2.A*B*p2.C;
                int t3 = p2.A*p2.B*C;
                return  t1 == t2 && t1 == t3;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(A, B, C);
        }
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return MessageFormat.format("x={0},y={1}",x,y);
    }
}
