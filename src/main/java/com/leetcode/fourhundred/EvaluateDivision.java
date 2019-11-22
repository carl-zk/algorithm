package com.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/evaluate-division/
 * <p>
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * <p>
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 *
 * @author carl
 */
public class EvaluateDivision {
    List<Double> ans = new ArrayList<>();
    Map<String, Map<String, Double>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            map.computeIfAbsent(eq.get(0), k -> new HashMap<>()).put(eq.get(1), values[i]);
            map.computeIfAbsent(eq.get(1), k -> new HashMap<>(16)).put(eq.get(0), 1.0 / values[i]);
        }

        for (List<String> q : queries) {
            double[] res = new double[]{1.0};
            if (map.containsKey(q.get(1)) && solve(map.get(q.get(0)), q.get(1), 1, res)) {
                ans.add(res[0]);
            } else {
                ans.add(-1.0);
            }
        }

        double[] res = new double[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean solve(Map<String, Double> ref, String divisor, int len, double[] res) {
        if (ref == null || len > map.size()) return false;
        for (Map.Entry<String, Double> entry : ref.entrySet()) {
            if (entry.getKey().equals(divisor)) {
                res[0] *= entry.getValue();
                return true;
            }
            res[0] *= entry.getValue();
            if (solve(map.get(entry.getKey()), divisor, len + 1, res)) return true;
            res[0] /= entry.getValue();
        }
        return false;
    }

    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();

        List<List<String>> eq = new ArrayList<>();
        eq.add(Arrays.asList("a", "b"));
        eq.add(Arrays.asList("b", "c"));

        double[] values = new double[]{2, 3};

        List<List<String>> qu = new ArrayList<>();
        qu.add(Arrays.asList("a", "c"));
        qu.add(Arrays.asList("b", "a"));
        qu.add(Arrays.asList("a", "e"));
        qu.add(Arrays.asList("a", "a"));
        qu.add(Arrays.asList("x", "x"));

        ed.calcEquation(eq, values, qu);
    }
}
