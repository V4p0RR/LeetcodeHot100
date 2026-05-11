package lc199_二叉树的右视图;

import java.util.*;

public class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        int depth = -1;
        dfs(root, depth);
        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        if (res.size() == depth) {
            res.add(root.val);
        }
        dfs(root.right, depth);
        dfs(root.left, depth);
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