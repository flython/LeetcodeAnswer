package fly.leetcode.cn.q341;

import java.util.Iterator;
import java.util.List;


/**
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 91.05% 的用户
 * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 96.66% 的用户
 */
//TODO 这道题应该还能更快
public class NestedIterator implements Iterator<Integer> {

    Iterator<NestedInteger> all;
    //递归到有haveNext的迭代器，或者为空，为了解决空嵌套
    Iterator<Integer> current;

    public NestedIterator(List<NestedInteger> nestedList) {
        all = nestedList.iterator();
        nextCurrent();
    }

    @Override
    public Integer next() {
        Integer next = current.next();
        //取完值后，如果current已到末尾，立刻修复current的指向
        if (!current.hasNext()){
            nextCurrent();
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return current != null && current.hasNext();
    }

    private void nextCurrent(){
        //当all有hasNext的时候持续下一个，直到找到非空数组或单值
        while (all.hasNext()){
            NestedInteger nestedInteger = all.next();
            if (nestedInteger.isInteger()){
                current = List.of(nestedInteger.getInteger()).iterator();
                return;
            } else {
                NestedIterator subIter = new NestedIterator(nestedInteger.getList());
                if (subIter.hasNext()){
                    current = subIter;
                    return;
                }
            }
        }
        current = null;
    }
}
