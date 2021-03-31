package fly.testutils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class ArrayCompareTest {
    //使用质数映射搭配乘法，可以保证不重复
    public static int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

    protected int hash(String str){
        int h = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            h*= primes['z'-chars[i]];
        }
        return h;
    }


    protected int hash(int[] integers){
        int h = 1;
        for (Integer integer : integers) {
            h *= primes[integer+10];
        }
        return h;
    }

    protected int hash(Collection<Integer> integers){
        return hash(integers.stream().mapToInt(Integer::intValue).toArray());
    }

    protected void assertMatrixEqual(int[][] expect, List<List<Integer>> actual){
        assertEquals(expect.length,actual.size());
        Set<Integer> expectHashs = Arrays.stream(expect).map(this::hash).collect(Collectors.toSet());
        for (List<Integer> list : actual) {
            System.out.printf("%s,",list);
            assertTrue(expectHashs.contains(this.hash(list)),()-> list + " does not exist in expect");
        }
        System.out.println();
    }
}
