package fly.leetcode.cn.q938;

import fly.leetcode.support.TreeNode;
import fly.testutils.converter.TreeConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '@',value = {
        "[10,5,15,3,7,null,18]@7@15@32",
        "[10,5,15,3,7,13,18,1,null,6]@6@10@23",
    })
    @ParameterizedTest
    void rangeSumBST(@ConvertWith(TreeConverter.class) TreeNode root, int low, int high, int expect) {
        assertEquals(expect,solution.rangeSumBST(root, low, high));
    }
}