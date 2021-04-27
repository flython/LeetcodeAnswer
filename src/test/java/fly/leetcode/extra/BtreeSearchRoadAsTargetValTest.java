package fly.leetcode.extra;

import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BtreeSearchRoadAsTargetValTest {

    @CsvSource(delimiter = '@',value = {
            "[5,4,8,11,null,13,4,7,2,null,null,5,1]@22"
    })
    @ParameterizedTest
    void solve(JSONArray array, int targetNumber) {
        LinkedList<Integer> tree = new LinkedList<>();
        for (int i = 0; i < array.size(); i++) {
            tree.add(array.getInteger(i));
        }
        List<List<Integer>> solve = BtreeSearchRoadAsTargetVal.solve(tree, targetNumber);
        System.out.println(solve);
    }
}