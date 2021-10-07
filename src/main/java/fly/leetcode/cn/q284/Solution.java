package fly.leetcode.cn.q284;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

class PeekingIterator implements Iterator<Integer> {
    AtomicReference<Integer> peek = new AtomicReference<>(null);
    private Iterator<Integer> iterator;


    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        peek.set(iterator.hasNext()?iterator.next():null);
    }

    public Integer peek() {
        return peek.get();
    }

    @Override
    public Integer next() {
        Integer p = peek.getAndSet(iterator.hasNext()?iterator.next():null);
        return p;
    }

    @Override
    public boolean hasNext() {
        return peek.get()!= null;
    }
}