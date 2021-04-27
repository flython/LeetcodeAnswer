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
        class Package{
            List<Integer> list;
            int sum = 0;
            public Package(List<Integer> list, int sum) {
                this.list = list;
                this.sum = sum;
            }
            public Optional<Package> add(int num){
                int tmp = sum+num;
                if (tmp <= target){
                    Package newOne = new Package(Stream.concat(list.stream(),Stream.of(num)).collect(Collectors.toList()),tmp);
                    return Optional.of(newOne);
                }
                return Optional.empty();
            }

            public List<Integer> getList() {
                return list;
            }

            @Override
            public String toString() {
                return "Package{" +
                        "list=" + list +
                        ", sum=" + sum +
                        '}';
            }
        }

        Queue<Package> roads = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        var first = new Package(List.of(tree.get(0)),tree.remove(0));
        roads.add(first);
        while (!tree.isEmpty()){
            int curSize = roads.size();
            for (int i = 0; i < curSize; i++) {
                Package curRoad = roads.poll();
                if (curRoad.sum==target){
                    curRoad.
                }
                for (int j = 0; j < 2; j++) {
                    Optional.ofNullable(tree.remove(0)).flatMap(curRoad::add).ifPresent(roads::offer);
                }
            }
        }

        return roads.stream().map(Package::getList).collect(Collectors.toList());

    }


}
