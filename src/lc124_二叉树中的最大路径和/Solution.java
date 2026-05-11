package lc124_二叉树中的最大路径和;

public class Solution {
    int max = 0;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = 0;
        if (left < 0 && right < 0) {
            sum = root.val;
        } else {
            sum = root.val + Math.max(left, right);
        }
        max = Math.max(sum, max);
        max = Math.max(max, root.val + left + right);
        return sum;
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