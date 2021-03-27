package fly.leetcode.interview.q1002;


import com.alibaba.fastjson.JSONArray;
import fly.leetcode.support.EratosthenesSievePrimes;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

@Log4j2
class SolutionTest {

    SolutionHash solution= new SolutionHash();

    @CsvSource(delimiter = '$',value = {
            "[\"ron\",\"huh\",\"gay\",\"tow\",\"moe\",\"tie\",\"who\",\"ion\",\"rep\",\"bob\",\"gte\",\"lee\",\"jay\",\"may\",\"wyo\",\"bay\",\"woe\",\"lip\",\"tit\",\"apt\",\"doe\",\"hot\",\"dis\",\"fop\",\"low\",\"bop\",\"apt\",\"dun\",\"ben\",\"paw\",\"ere\",\"bad\",\"ill\",\"fla\",\"mop\",\"tut\",\"sol\",\"peg\",\"pop\",\"les\"]",
            "[\"eat\", \"tea\", \"tan\", \"ate\",\"nat\", \"bat\",\"boo\",\"bob\"]",
            "[\"hos\",\"boo\",\"nay\",\"deb\",\"wow\",\"bop\",\"bob\",\"brr\",\"hey\",\"rye\",\"eve\",\"elf\",\"pup\",\"bum\",\"iva\",\"lyx\",\"yap\",\"ugh\",\"hem\",\"rod\",\"aha\",\"nam\",\"gap\",\"yea\",\"doc\",\"pen\",\"job\",\"dis\",\"max\",\"oho\",\"jed\",\"lye\",\"ram\",\"pup\",\"qua\",\"ugh\",\"mir\",\"nap\",\"deb\",\"hog\",\"let\",\"gym\",\"bye\",\"lon\",\"aft\",\"eel\",\"sol\",\"jab\"]",
    })
    @ParameterizedTest
    void test(JSONArray input){
        String[] strings = input.toArray(String[]::new);
        List<List<String>> res = solution.groupAnagrams(strings);
        System.out.println(res);
    }

    @Test
    void primes(){
        var primes = new EratosthenesSievePrimes().getPrimes(135);
        System.out.println(Arrays.toString(primes));
        System.out.println(primes.length);
    }

    public int hash2(String str){
        int h = 0;
        int h2 = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            h+=(chars[i]-97);
            h*=(chars[i]-97);
        }
        return (h2-h)*(h2+h) & -1>>>8 | chars.length << 26;
    }
}