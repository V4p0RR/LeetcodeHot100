package lc543_二叉树的直径;


public class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return max;
    }

    public int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = f(root.left);
        int right = f(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
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