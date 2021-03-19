package fly.test.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringArrayConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        String array = (String) source;
        JSONArray jsonArray = JSON.parseArray(array);
        String[] res = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            res[i] = jsonArray.getString(i);
        }
        return res;
    }
}
