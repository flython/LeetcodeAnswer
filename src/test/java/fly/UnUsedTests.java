package fly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class UnUsedTests {

    @Test
    public void checkingObjectNull(){
        String str = null;
        LinkedHashSet<Integer> set = null;
        Integer integer = null;
        assertTrue(Objects.equals(set,str));
        assertTrue(((Comparable) str) == integer);
    }
}
