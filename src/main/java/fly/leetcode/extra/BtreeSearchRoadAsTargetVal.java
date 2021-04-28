package fly.leetcode.extra;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 题目地址：
 * https://leetcode-cn.com/circle/discuss/fLQhdY/
 */
public class BtreeSearchRoadAsTargetVal {
    public static List<List<Integer>> solve(List<Integer> tree, int target){

        Queue<Node> leaves = new LinkedList<>();
        leaves.offer(new Node(null, tree.remove(0)));
        while (!tree.isEmpty()){
            Node poll = leaves.poll();
            for (int i = 0; i < 2 && !tree.isEmpty(); i++) {
                Optional.ofNullable(tree.remove(0)).ifPresent(val->{
                    leaves.offer(new Node(poll,val));
                });
            }
        }

        List<List<Integer>> collect = leaves.stream().filter(leaf -> leaf.sum == target).map(leaf -> {
            LinkedList<Integer> list = new LinkedList<>();
            Node ptr = leaf;
            while (ptr != null) {
                list.addFirst(ptr.val);
                ptr = ptr.parrent;
            }
            return list;
        }).collect(Collectors.toList());
        return collect;
    }


    static class Node {
        int val;
        int sum;
        Node parrent;
        public Node(Node parrent, int val) {
            this.parrent = parrent;
            this.val = val;
            this.sum = parrent==null?val:parrent.sum+val;
        }

    }

}
