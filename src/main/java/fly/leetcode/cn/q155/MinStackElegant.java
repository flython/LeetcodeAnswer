package fly.leetcode.cn.q155;


class MinStackElegant {

    public static final int  DEFAULT_STACK_SIZE = 10;

    //0->value 1->min
    int[][] values = new int[DEFAULT_STACK_SIZE][];

    int pos = 0;
    public void push(int x) {
        if (pos==0){
            values[pos] = new int[]{x,x};
        } else if (values[pos] == null){
            values[pos] = new int[]{x,Math.min(x,values[pos-1][1])};
        } else {
            values[pos][0] = x;
            values[pos][1] = Math.min(x,values[pos-1][1]);
        }

        if (++pos >= values.length){
            int[][] olds = values;
            values = new int[(int) (pos*1.5)][];
            System.arraycopy(olds,0,values,0,pos);
        }

    }

    public void pop() {
        pos--;
    }

    public int top() {
        return values[pos-1][0];
    }

    public int getMin() {
        return values[pos-1][1];
    }
}
