package fly.testutils.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntMatrixConverter extends SimpleArgumentConverter {
    @Override
    protected int[][] convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        String array = (String) source;
        JSONArray jsonArray = JSON.parseArray(array);
        int[][] matrix = jsonArray.stream().map(o -> {
            return ((JSONArray) o).stream().map(i -> (Integer) i).mapToInt(Integer::intValue).toArray();
        }).toArray(int[][]::new);
        return matrix;
    }
}
