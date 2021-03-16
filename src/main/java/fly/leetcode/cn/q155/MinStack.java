package fly.leetcode.cn.q155;


import java.util.BitSet;

class MinStack {
    Node top;
    Node min;

    class Node{
        int value;
        Node pre;
        Node lesser;
        Node grater;

        public Node(int value, Node pre) {
            this.value = value;
            this.pre = pre;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        Node xn = new Node(x, top);
        this.top = xn;
        if (min == null || x <= min.value){
            xn.grater = min;
            this.min = xn;
        } else {
            Node t = min;
            while ((t = t.grater)!=null){
                if (x >= t.value){
                    xn.grater = t.grater;
                    xn.lesser = t;
                    t.grater = xn;
                    break;
                }
            }
        }

    }

    public void pop() {
        Node pop = top;
        top = top.pre;
        if (pop == min){
            min = min.grater;
        } else{
            //修复链接关系
            if (pop.grater != null){
                pop.grater.lesser = pop.lesser;
            }
            if (pop.lesser != null){
                pop.lesser.grater = pop.grater;
            }
        }

    }

    public int top() {
        return top.value;
    }

    public int getMin() {
        return min.value;
    }
}
