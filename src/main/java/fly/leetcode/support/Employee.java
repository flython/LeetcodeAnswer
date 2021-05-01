package fly.leetcode.support;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
public class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
