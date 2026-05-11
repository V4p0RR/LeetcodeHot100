package lc437_路径总和III;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Long, Integer> map = new HashMap<>();
    int res = 0;
    Long tar = 0L;

    public int pathSum(TreeNode root, int targetSum) {
        tar = (long) targetSum;
        map.put(0L, 1);
        Long sum = 0L;
        dfs(root, sum);

        return res;
    }

    public void dfs(TreeNode root, Long sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        res += map.getOrDefault(sum - tar, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(root.left, sum);
        dfs(root.right, sum);
        map.put(sum, map.get(sum) - 1);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}