package fly.leetcode.cn.q1143;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution2dimOptimize solution = new Solution2dimOptimize();
    @CsvSource({
            "aaaaa,aab,2",
            "gjkshdufdsufdsukfukdsayfkusdfskjsdhfdgyitqwertyuiadakdjdghajsdbvnxbvmxncbxvwayufadaoewbgueabgsuadgiusdaygdusgusadgjsdb,aidlfhagnlsdagdalsigudlaishslakgjladsuiahslidhlkjglsakjghlsa,26",
            "abcde,ace,3",
            "abc,abc,3",
            "abc,def,0",
            "a,a,1",
            "a,b,0",
            "atqisdhteeqijof,stqio,5",
            "atqisdhteebijof,atqbo,5",
            "atqisdhteebijof,btqbo,4",
            "atqisdhteeqijof,atqbo,4",
            "bbbcbb,abbcb,4"
    })
    @ParameterizedTest
    void longestCommonSubsequence(String t1,String t2,int expect) {
       assertEquals(expect,solution.longestCommonSubsequence(t1,t2));
    }
}