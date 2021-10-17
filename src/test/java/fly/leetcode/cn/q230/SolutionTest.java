package fly.leetcode.cn.q230;

import fly.leetcode.support.TreeNode;
import fly.testutils.converter.TreeConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource(delimiter = '$',value = {
            "[3,1,4,null,2]$4$4",
            "[3]$1$3",
            "[5,3,6,2,4,null,null,1]$3$3",
            "[5,3,6,2,4,null,null,1]$4$4",
            "[5,3,6,2,4,null,null,1]$6$6",
    })
    @ParameterizedTest
    void kthSmallest(@ConvertWith(TreeConverter.class) TreeNode root, int k, int exp) {
        assertEquals(exp,new Solution().kthSmallest(root,k));
    }
}