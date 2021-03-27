package fly.leetcode.interview.q1002;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution= new Solution();

    @Test
    void groupAnagrams() {
        List<List<String>> res = solution.groupAnagrams(Stream.of("eat", "tea", "tan", "ate", "nat", "bat").toArray(String[]::new));
        System.out.println(res);

    }

    @Test
    void  testHash(){
        assertNotEquals(solution.hash("ids"),solution.hash("tic"));
    }

    @DisplayName("yahaha")
    @Test
    void printBin(){
        "dstc".chars().forEach(c->
                System.out.println(String.format("%c bin is %s", c, Integer.toBinaryString(c)))
        );
        "abcdefghijklmnopqrstuvwxyz".chars().forEach(c->{
            char c1 = (char) (c>>4 ^ c);
            System.out.println(Integer.toBinaryString(c));
            System.out.println(Integer.toBinaryString(c1&0b00001111));
        });
    }
}