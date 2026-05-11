package lc78_子集;

import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int start, List<Integer> cur) {
        res.add(new ArrayList<>(cur));//每层都加
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, i + 1, cur);
            cur.removeLast();
        }
    }
}
