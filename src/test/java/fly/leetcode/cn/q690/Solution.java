package fly.leetcode.cn.q690;

import fly.leetcode.support.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> company = employees.stream().collect(Collectors.toMap(e->e.id, Function.identity()));
        int res = 0;
        employees.clear();
        employees.add(company.get(id));
        while (!employees.isEmpty()){
            Employee poll = employees.remove(0);
            res += poll.importance;
            poll.subordinates.stream().map(company::get).forEach(employees::add);
        }
        return res;
    }
}