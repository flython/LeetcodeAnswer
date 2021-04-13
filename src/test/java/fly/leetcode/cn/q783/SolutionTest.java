package fly.leetcode.cn.q783;

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
            "[1,0,48,null,null,12,49]@1",
            "[4,2,6,1,3]@1",
            "[48684,1]@48683",
            "[1,-150]@151",
    })
    @ParameterizedTest
    void minDiffInBST(@ConvertWith(TreeConverter.class) TreeNode root, int expect) {
        assertEquals(expect,solution.minDiffInBST(root));
    }
}