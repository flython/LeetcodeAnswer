package fly.leetcode.cn.q341;

import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.stream.Collectors;

public class NestedIntegerImpl implements NestedInteger{

    Object val;

    public NestedIntegerImpl(Object val) {
        if (val instanceof Integer){
            this.val = val;
        } else {
            JSONArray jsonArray = (JSONArray) val;
            this.val =  jsonArray.stream().map(NestedIntegerImpl::new).collect(Collectors.toList());
        }
    }

    @Override
    public boolean isInteger() {
        return val instanceof Integer;
    }

    @Override
    public Integer getInteger() {
        return (Integer) val;
    }

    @Override
    public List<NestedInteger> getList() {
        return (List<NestedInteger>) val;
    }
}
