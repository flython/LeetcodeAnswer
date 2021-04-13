package fly.testutils.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import fly.leetcode.support.TreeNode;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import javax.swing.text.html.Option;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class TreeConverter extends SimpleArgumentConverter {
    @Override
    protected TreeNode convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        String array = (String) source;
        JSONArray jsonArray = JSON.parseArray(array);
        if (jsonArray.size() == 0 || jsonArray.getInteger(0) == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        var res = new TreeNode(jsonArray.getInteger(0));
        queue.offer(res);
        for (int i = 1; i < jsonArray.size(); i++) {
            var opt = Optional.ofNullable(jsonArray.getInteger(i)).map(TreeNode::new);
            opt.ifPresent(queue::offer);
            var n = opt.orElse(null);
            if ((i&1) == 1){
                queue.peek().left = n;
            } else {
                queue.poll().right = n;
            }
        }
        return res;
    }
}
