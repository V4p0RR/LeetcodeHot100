package lc39_组合总和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    void dfs(int[] candidates, int tar, List<Integer> cur, int sum, int start) {
        if (sum == tar) {
            res.add(new ArrayList<>(cur));
            return;
        } else if (sum > tar) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, tar, cur, sum, i);
            cur.removeLast();
            sum -= candidates[i];
        }
    }
}
