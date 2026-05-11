package lc46_全排列;

import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    void dfs(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {//放入答案,返回
            res.add(new ArrayList<>(path));//一定要放新建的 不然修改path会影响res里的
            return;
        }
        for (int i = 0; i < nums.length; i++) {//加入每个没用过的数字 递归
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, used);
            //回溯 去掉当前选择的
            path.removeLast();
            used[i] = false;
        }
    }
}
