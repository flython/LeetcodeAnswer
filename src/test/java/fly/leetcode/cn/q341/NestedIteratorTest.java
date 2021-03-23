package fly.leetcode.cn.q341;

import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
class NestedIteratorTest {

    @CsvSource(delimiter = '&',value = {
            "[[1,1],2,[1,1]]&[1,1,2,1,1]",
            "[[],[],[]]&[]",
            "[[],[[],[],[[],[]]],[]]&[]",
            "[[],[[],[1],[[],[2,3]]],[]]&[1,2,3]",
            "[1,[4,[6]]]&[1,4,6]"
    })
    @ParameterizedTest
    void next(JSONArray input, JSONArray res) {
        List<NestedInteger> collect = input.stream().map(NestedIntegerImpl::new).collect(Collectors.toList());
        NestedIterator nestedIterator = new NestedIterator(collect);
        int i = 0;
        while (nestedIterator.hasNext()){
            assertEquals(res.getInteger(i),nestedIterator.next());
            i++;
        }
        assertEquals(i , res.size());
    }
}